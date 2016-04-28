package org.pyload.android.client.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import org.pyload.android.client.BuildConfig;
import org.pyload.android.client.R;
import org.pyload.android.client.data.UpdateInfo;
import org.pyload.android.client.network.UpdateDownloadTask;
import org.pyload.android.client.pyLoadApp;

import java.io.File;

/**
 * Created by Martin on 13.04.2016.
 */
public class UpdateUtil
{
    private static final String TAG = "UpdateUtil";
    
    private static UpdateUtil instance;
    private Activity activity;
    private boolean manualCheck = false;

    private UpdateUtil(Activity activity)
    {
        this.activity = activity;
    }

    public static UpdateUtil getInstance(@NonNull Activity context)
    {
        if(null==instance)
        {
            instance = new UpdateUtil(context);
        }
        return instance;
    }

    public void setActivity (Activity activity)
    {
        this.activity = activity;
    }

    private void installUpdate(final String path)
    {
        if(null==activity)
        {
            Log.e(TAG, "installUpdate: context is null");
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
        activity.startActivity(intent);
    }

    public void showDialog(final String path)
    {
        if(null==activity)
        {
            Log.e(TAG, "showDialog: context is null" );
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Update available");
        builder.setMessage("Do you want to update " + activity.getString(R.string.app_name) + " now?");
        builder.setCancelable(true);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick (DialogInterface dialog, int which)
            {
                installUpdate(path);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Not now", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick (DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        if( activity.hasWindowFocus())
            builder.create().show();
        else
            Log.e(TAG, "showDialog: context has no focus");
    }

    public void evaluate(@NonNull UpdateInfo info)
    {
        if(null == info)
        {
            Log.e(TAG, "evaluate: info is null");
            return;
        }

        int current = BuildConfig.VERSION_CODE;

        if(current < info.getVersionCode())
        {
            UpdateDownloadTask task = new UpdateDownloadTask(info);
            task.execute();
        }
        else 
        {
            Log.d(TAG, "evaluate: no update available");
            Toast.makeText(activity, "no update available", Toast.LENGTH_SHORT).show();
        }
    }
}
