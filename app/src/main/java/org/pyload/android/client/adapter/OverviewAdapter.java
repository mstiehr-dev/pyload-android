package org.pyload.android.client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.pyload.android.client.R;
import org.pyload.android.client.module.Utils;
import org.pyload.android.client.pyLoadApp;
import org.pyload.thrift.DownloadInfo;
import org.pyload.thrift.DownloadStatus;

import java.util.List;

/**
 * Renders the single ListView items
 *
 * @author RaNaN
 *
 */
public class OverviewAdapter extends BaseAdapter
{

    static class ViewHolder {
        private TextView name;
        private ProgressBar progress;
        private TextView size;
        private TextView percent;
        private TextView size_done;
        private TextView speed;
        private TextView eta;
    }

    private final pyLoadApp app;
    private List<DownloadInfo> downloads;
    private final int rowResID;
    private final LayoutInflater layoutInflater;

    public OverviewAdapter(final pyLoadApp app, final int rowResID,
            List<DownloadInfo> downloads) {
        this.app = app;
        this.rowResID = rowResID;
        this.downloads = downloads;

        layoutInflater = (LayoutInflater) app
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDownloads(List<DownloadInfo> downloads) {
        this.downloads = downloads;
        notifyDataSetChanged();
    }

    public int getCount() {
        return downloads.size();
    }

    public Object getItem(int id) {
        return downloads.get(id);
    }

    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        DownloadInfo info = downloads.get(position);
        if (convertView == null) {
            convertView = layoutInflater.inflate(rowResID, null);
            ViewHolder holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.progress = (ProgressBar) convertView
                    .findViewById(R.id.progress);
            holder.size = (TextView) convertView.findViewById(R.id.size);
            holder.speed = (TextView) convertView.findViewById(R.id.speed);
            holder.size_done = (TextView) convertView
                    .findViewById(R.id.size_done);
            holder.eta = (TextView) convertView.findViewById(R.id.eta);
            holder.percent = (TextView) convertView.findViewById(R.id.percent);
            convertView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) convertView.getTag();


        // name is null sometimes somehow
        if (info.name != null && !info.name.equals(holder.name.getText())) {
            holder.name.setText(info.name);
        }

        holder.progress.setProgress(info.percent);

        if (info.status == DownloadStatus.Downloading) {
            holder.size.setText(Utils.formatSize(info.size));
            holder.percent.setText(info.percent + "%");
            holder.size_done.setText(Utils.formatSize(info.size - info.bleft));

            holder.speed.setText(Utils.formatSize(info.speed) + "/s");
            holder.eta.setText(info.format_eta);

        } else if (info.status == DownloadStatus.Waiting) {
            holder.size.setText(R.string.lambda);
            holder.percent.setText(R.string.lambda);
            holder.size_done.setText(R.string.lambda);

            holder.speed.setText(info.statusmsg);
            holder.eta.setText(info.format_wait);

        } else {
            holder.size.setText(R.string.lambda);
            holder.percent.setText(R.string.lambda);
            holder.size_done.setText(R.string.lambda);

            holder.speed.setText(info.statusmsg);
            holder.eta.setText(R.string.lambda);
        }

        return convertView;

    }

    public boolean hasStableIds() {
        return false;
    }


}