package org.pyload.android.client.fragments;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.*;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import org.pyload.android.client.BuildConfig;
import org.pyload.android.client.R;
import org.pyload.android.client.adapter.OverviewAdapter;
import org.pyload.android.client.components.TabHandler;
import org.pyload.android.client.dialogs.CaptchaDialog;
import org.pyload.android.client.module.GuiTask;
import org.pyload.android.client.module.Utils;
import org.pyload.android.client.pyLoad;
import org.pyload.android.client.pyLoadApp;
import org.pyload.thrift.CaptchaTask;
import org.pyload.thrift.DownloadInfo;
import org.pyload.thrift.Pyload.Client;
import org.pyload.thrift.ServerStatus;

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends ListFragment implements
        OnDismissListener, TabHandler
{

    public final static int CAPTCHA_DIALOG = 0;

    private pyLoadApp app;
    private Client client;
    private OverviewAdapter adp;

    private List<DownloadInfo> downloads;
    private ServerStatus status;
    private CaptchaTask captcha;
    private int lastCaptcha = -1;
    private int interval = 5;
    private boolean update = false;
    private boolean dialogOpen = false;
    // tab position
    private int pos = -1;

    /**
     * GUI Elements
     */
    private TextView statusServer;
    private TextView reconnect;
    private TextView speed;
    private TextView active;

    private final Handler mHandler = new Handler();
    private final Runnable mUpdateResults = new Runnable()
    {

        public void run ()
        {
            onDataReceived();
        }
    };
    private final Runnable runUpdate = new Runnable()
    {

        public void run ()
        {
            client = app.getClient();
            downloads = client.statusDownloads();
            status = client.statusServer();
            if (client.isCaptchaWaiting())
            {
                Log.d("pyLoad", "Captcha available");
                captcha = client.getCaptchaTask(false);
                Log.d("pyload", captcha.resultType);
            }
        }
    };

    private final Runnable cancelUpdate = new Runnable()
    {

        public void run ()
        {
            stopUpdate();
        }
    };

    private final Runnable mUpdateTimeTask = new Runnable()
    {
        public void run ()
        {
            refresh();
            if (update)
                mHandler.postDelayed(this, interval * 1000);
        }
    };

    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        app = (pyLoadApp) getActivity().getApplicationContext();

        downloads = new ArrayList<DownloadInfo>();
        adp = new OverviewAdapter(app, R.layout.overview_item, downloads);

    }

    @Override
    public void onListItemClick (ListView l, View v, int position, long id)
    {
        if(BuildConfig.DEBUG)
        {
            showNotification(getContext(), R.string.abort);
        }
        super.onListItemClick(l, v, position, id);
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.overview, null, false);

        statusServer = (TextView) v.findViewById(R.id.status_server);
        reconnect = (TextView) v.findViewById(R.id.reconnect);
        speed = (TextView) v.findViewById(R.id.speed);
        active = (TextView) v.findViewById(R.id.active);

        // toggle pause on click
        statusServer.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                app.addTask(new GuiTask(new Runnable()
                {
                    public void run ()
                    {
                        Client client = app.getClient();
                        client.togglePause();
                    }
                }, app.handleSuccess));
            }
        });

        // toggle reconnect on click
        reconnect.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                app.addTask(new GuiTask(new Runnable()
                {
                    public void run ()
                    {
                        Client client = app.getClient();
                        client.toggleReconnect();
                    }
                }, app.handleSuccess));
            }
        });

        if (status != null && downloads != null)
            onDataReceived();

        registerForContextMenu(v.findViewById(android.R.id.list));

        return v;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(adp);
    }

    @Override
    public void onStart ()
    {
        super.onStart();
        onSelected();
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,
            ContextMenuInfo menuInfo)
    {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.overview_context_menu, menu);
        menu.setHeaderTitle(R.string.choose_action);
    }

    @Override
    public boolean onContextItemSelected (MenuItem item)
    {

        if (!app.isCurrentTab(pos))
            return false;

        AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item
                .getMenuInfo();
        final int id = menuInfo.position;
        final DownloadInfo info = downloads.get(id);
        switch (item.getItemId())
        {
            case R.id.abort:

                app.addTask(new GuiTask(new Runnable()
                {

                    public void run ()
                    {
                        client = app.getClient();
                        ArrayList<Integer> fids = new ArrayList<Integer>();
                        fids.add(info.fid);
                        client.stopDownloads(fids);
                    }
                }, new Runnable()
                {

                    public void run ()
                    {
                        refresh();
                    }
                }));
                return true;

            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onSelected ()
    {
        startUpdate();
    }

    @Override
    public void onDeselected ()
    {
        stopUpdate();
    }

    private void startUpdate ()
    {
        // already update running
        if (update)
            return;
        try
        {
            interval = Integer.parseInt(app.prefs
                    .getString("refresh_rate", "5"));
        }
        catch (NumberFormatException e)
        {
            // somehow contains illegal value
            interval = 5;
        }

        update = true;
        mHandler.post(mUpdateTimeTask);
    }

    private void stopUpdate ()
    {
        update = false;
        mHandler.removeCallbacks(mUpdateTimeTask);
    }

    /**
     * Called when Status data received
     */
    protected void onDataReceived ()
    {
        OverviewAdapter adapter = (OverviewAdapter) getListAdapter();

        adapter.setDownloads(downloads);

        if(null == downloads || 0 == downloads.size())
        {   // now downloads active
            showNotification(getContext(), R.string.download_finished);
            return;
        }

        statusServer.setText(app.verboseBool(status.download));
        reconnect.setText(app.verboseBool(status.reconnect));
        speed.setText(Utils.formatSize(status.speed) + "/s");
        active.setText(String.format("%d / %d", status.active, status.total));

        if (captcha != null && app.prefs.getBoolean("pull_captcha", true)
                && captcha.resultType != null // string null bug
                && captcha.resultType.equals("textual")
                && lastCaptcha != captcha.tid)
        {
            showCaptureDialog();
        }

    }

    public void refresh ()
    {
        if (!app.hasConnection())
            return;

        GuiTask task = new GuiTask(runUpdate, mUpdateResults);
        task.setCritical(cancelUpdate);

        app.addTask(task);
    }

    private void showCaptureDialog ()
    {

        if (dialogOpen || captcha == null)
            return;

        showNotification(getContext(), R.string.captcha_available);

        CaptchaDialog dialog = CaptchaDialog.newInstance(captcha);
        lastCaptcha = captcha.tid;

        Log.d("pyLoad", "Got Captcha Task");

        dialog.setOnDismissListener(this);

        dialogOpen = true;
        try
        {
            dialog.show(getFragmentManager(), CaptchaDialog.class.getName());
        }
        catch (IllegalStateException e)
        {
            dialogOpen = false;
            // seems to appear when overview is already closed
            Log.e("pyLoad", "Dialog state error", e);
        }
        catch (NullPointerException e)
        {
            dialogOpen = false;
            // something is null, but why?
            Log.e("pyLoad", "Dialog null pointer error", e);
        }

    }


    public static void showNotification(Context ctx, @StringRes int msg)
    {
        if(null == ctx)
        {
            return;
        }
        showNotification(ctx, ctx.getString(msg));
    }

    public static void showNotification (Context ctx, String message)
    {
        long[] vibratorPattern = {250, 100, 250, 100, 250, 100, 250, 100, 250, 100};
        String contentTitle = "Pyload";
        Intent intent = new Intent(ctx, pyLoad.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setAction("SHOW_QUEUE");
        PendingIntent pendingIntent = PendingIntent.getActivity(ctx, 0, intent, Intent.FILL_IN_ACTION);

        NotificationManager mNotifyMgr = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification.Builder(ctx)
                .setLights(Color.GREEN, 100, 100)
                .setVibrate(vibratorPattern)
                .setContentIntent(pendingIntent)
                .setContentTitle(contentTitle)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher)
                .setAutoCancel(true)
                .build();
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        notification.defaults |= Notification.DEFAULT_SOUND;

        mNotifyMgr.notify(1337, notification);
    }

    public void onDismiss (DialogInterface arg0)
    {
        captcha = null;
        dialogOpen = false;
    }

    @Override
    public void setPosition (int pos)
    {
        this.pos = pos;
    }


}
