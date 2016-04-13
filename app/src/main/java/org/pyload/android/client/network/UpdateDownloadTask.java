package org.pyload.android.client.network;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.pyload.android.client.data.UpdateInfo;
import org.pyload.android.client.pyLoad;
import org.pyload.android.client.util.UpdateUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Martin on 13.04.2016.
 */
public class UpdateDownloadTask extends AsyncTask<Void, Void, String>
{
    private static final String TAG = "UpdateDownloadTask";

    private UpdateInfo info;

    public UpdateDownloadTask (@NonNull UpdateInfo info)
    {
        this.info = info;
    }

    @Override
    protected void onPreExecute ()
    {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground (Void... params)
    {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(info.getSrc())
                    .build();
            Response response = client.newCall(request).execute();
            if(null != response && response.isSuccessful())
            {
                String filename = info.getSrc();
                while(filename.contains("/"))
                {
                    int pos = filename.indexOf("/");
                    filename = filename.substring(pos+1, filename.length());
                }
                File f = new File(Environment.getExternalStorageDirectory() + File.separator + filename);
                String fullPath = f.getAbsolutePath();
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(response.body().bytes());
                fos.close();
                return fullPath;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute (String path)
    {
        pyLoad.updateUtil.showDialog(path);
    }
}
