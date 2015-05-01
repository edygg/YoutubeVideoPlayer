package me.edilsongonzalez.youtubevideoplayer;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	// Components
	private Button btnPlayVideo;
	private Button btnPlayPlaylist;
	
	private void initComponents() {
		this.btnPlayVideo = (Button) findViewById(R.id.play_video_btn);
		this.btnPlayVideo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btnPlayVideoClicked(v);
			}
		});
		this.btnPlayPlaylist = (Button) findViewById(R.id.play_playlist_btn);
		this.btnPlayPlaylist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				btnPlayPlaylistClicked(v);
			}
		});
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initComponents();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void btnPlayVideoClicked(View v) {
		Intent intent = YouTubeStandalonePlayer.createVideoIntent(this, ParametersAndVariables.YOUTUBE_API_KEY, ParametersAndVariables.TEST_YOUTUBE_VIDEO_ID);
		startActivityForResult(intent, 0);
	}
	
	public void btnPlayPlaylistClicked(View v) {
		Intent intent = YouTubeStandalonePlayer.createPlaylistIntent(this, ParametersAndVariables.YOUTUBE_API_KEY, ParametersAndVariables.TEST_YOUTUBE_PLAYLIST_ID);
		startActivityForResult(intent, 0);
	}
}
