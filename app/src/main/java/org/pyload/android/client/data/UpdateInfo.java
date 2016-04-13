package org.pyload.android.client.data;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Martin on 13.04.2016.
 */
public class UpdateInfo
{
    int versionCode = -1;
    String src = "";
    String changelog = "";
    String md5 = "";

    public int getVersionCode ()
    {
        return versionCode;
    }

    public String getSrc ()
    {
        return src;
    }

    public String getChangelog ()
    {
        return changelog;
    }
}
