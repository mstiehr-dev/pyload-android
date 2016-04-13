package org.pyload.android.client.network;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.pyload.android.client.BuildConfig;
import org.pyload.android.client.R;
import org.pyload.android.client.data.UpdateInfo;
import org.pyload.android.client.pyLoadApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Martin on 13.04.2016.
 */
public class UpdateInfoLoader extends android.support.v4.content.AsyncTaskLoader<UpdateInfo>
{
    private static final String TAG = "UpdateInfoLoader";

    public UpdateInfoLoader (Context context)
    {
        super(context);
    }

    @Override
    public UpdateInfo loadInBackground ()
    {
        pyLoadApp app = (pyLoadApp) getContext().getApplicationContext();
        long now = System.currentTimeMillis();
        final long ONE_DAY = 24 * 60 * 60 * 1000;
        if (null == app)
        {
            Log.e(TAG, "loadInBackground: could not get application");
            return null;
        }
        if (!app.manualUpdateCheck && now - app.prefs.getLong("last_update_timestamp", 0) < ONE_DAY)
        {
            Log.d(TAG, "checked for update less than 24h ago - aborting");
            return null;
        }
        SharedPreferences.Editor editor = app.prefs.edit();
        editor.putLong("last_update_timestamp", now);
        editor.apply();
        app.manualUpdateCheck = false;

        URL url = null;
        OkHttpClient client = new OkHttpClient();

        try

        {
            url = new URL(getContext().getString(R.string.update_info_url));
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            if (null != response && response.isSuccessful())
            {
                Gson gson = new Gson();
                UpdateInfo info = gson.fromJson(response.body().string(), UpdateInfo.class);
                Log.d(TAG, "loadInBackground: " + info.toString());
                return info;
            }
        }

        catch (
                MalformedURLException e
                )

        {
            Log.e(TAG, "loadInBackground: error parsing url: " + url, e);
        }

        catch (
                IOException e
                )

        {
            Log.e(TAG, "loadInBackground: " + e.getStackTrace());
        }

        return null;
    }
}
