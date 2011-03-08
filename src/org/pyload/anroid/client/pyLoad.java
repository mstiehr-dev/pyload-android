package org.pyload.anroid.client;

import java.util.ArrayList;

import org.pyload.thrift.Destination;
import org.pyload.thrift.Pyload.Client;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TabHost;

public class pyLoad extends TabActivity {

	private pyLoadApp app;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		app = (pyLoadApp) getApplicationContext();

		Log.d("pyLoad", "Starting TaskQueue");

		app.prefs = PreferenceManager.getDefaultSharedPreferences(this);
		app.cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		app.init();

		Resources res = getResources(); // Resource object to get Drawables
		TabHost tabHost = getTabHost(); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		// Create an Intent to launch an Activity for the tab (to be reused)
		intent = new Intent().setClass(this, OverviewActivity.class);

		// Initialize a TabSpec for each tab and add it to the TabHost
		spec = tabHost.newTabSpec("Overview")
				.setIndicator("Overview", res.getDrawable(R.drawable.icon))
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, QueueActivity.class);
		String queue = app.getString(R.string.queue);
		spec = tabHost.newTabSpec(queue)
				.setIndicator(queue, res.getDrawable(R.drawable.icon))
				.setContent(intent);
		tabHost.addTab(spec);

		String collector = app.getString(R.string.collector);
		intent = new Intent().setClass(this, CollectorActivity.class);
		spec = tabHost.newTabSpec(collector)
				.setIndicator(collector, res.getDrawable(R.drawable.icon))
				.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_links:

			startActivityForResult(new Intent(app, AddLinksActivity.class), 0);

			return true;

		case R.id.refresh:

			TabHost tabHost = getTabHost();
			int tab = tabHost.getCurrentTab();

			app.refreshTab(tab);

			return true;

		case R.id.settings:
			Intent settingsActivity = new Intent(app, Preferences.class);
			startActivity(settingsActivity);

			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		
		switch (requestCode) {
		case 0:
			switch (resultCode) {
			case RESULT_OK:
				
				final String name = data.getStringExtra("name");
				final String[] link_array = data.getStringExtra("links").split("\n");
				final Destination dest;
				
				if(data.getIntExtra("dest", 0) == 0)
					dest = Destination.Queue;
				else
					dest = Destination.Collector;
				
				final ArrayList<String> links = new ArrayList<String>();
				for (String link: link_array){
					links.add(link);
				}
				
				// TODO: password				

				app.addTask(new GuiTask(new Runnable() {
					
					@Override
					public void run() {
						Client client = app.getClient();
						client.addPackage(name, links, dest);
						
					}
				},app.handleSuccess));
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}

	}

}