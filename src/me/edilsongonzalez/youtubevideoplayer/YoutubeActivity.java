package me.edilsongonzalez.youtubevideoplayer;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

	private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
		
		@Override
		public void onStopped() {
			
		}
		
		@Override
		public void onSeekTo(int arg0) {
			
		}
		
		@Override
		public void onPlaying() {
			
		}
		
		@Override
		public void onPaused() {
			
		}
		
		@Override
		public void onBuffering(boolean arg0) {
			
		}
	};
	
	private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
		
		@Override
		public void onVideoStarted() {
			
		}
		
		@Override
		public void onVideoEnded() {
			
		}
		
		@Override
		public void onLoading() {
			
		}
		
		@Override
		public void onLoaded(String arg0) {
			
		}
		
		@Override
		public void onError(ErrorReason arg0) {
			
		}
		
		@Override
		public void onAdStarted() {
			
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_youtube);
		YouTubePlayerView youtubePlayer = (YouTubePlayerView) findViewById(R.id.youtube_player);
		youtubePlayer.initialize(ParametersAndVariables.YOUTUBE_API_KEY, this);
	}

	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
		Toast.makeText(this, "Cannot initialize Youtube player", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRetored) {
		player.setPlayerStateChangeListener(playerStateChangeListener);
		player.setPlaybackEventListener(playbackEventListener);
		
		if (!wasRetored) {
			player.cueVideo(ParametersAndVariables.TEST_YOUTUBE_VIDEO_ID);
		}
	}
	
	

}
