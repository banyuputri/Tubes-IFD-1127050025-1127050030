package com.bd.lagusong;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.MenuItem;

public class Play1 extends ActionBarActivity implements MediaPlayer.OnCompletionListener {
	public final static String Krm_Param = "com.bd.lagusong.MESSAGE"; 
	private ImageButton play;
	private ImageButton pause;
	private ImageButton stop;
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play1);
		play=(ImageButton)findViewById(R.id.play);
		pause=(ImageButton)findViewById(R.id.pause);
		stop=(ImageButton)findViewById(R.id.stop);
		play.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view) {
				play();
	}
		});
		pause.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				pause();
			}
		});
		
		stop.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				stop();
			}
		});
		setup();
	}
//Ini dari banyu
public void onDestroy(){
		super.onDestroy();
		if (stop.isEnabled()) {
			stop();
		}
	}
	public void onCompletion(MediaPlayer mp) {
		stop();
	}
	
	private void play(){
		mp.start();
		
		play.setEnabled(false);
		pause.setEnabled(true);
		stop.setEnabled(true);
	}
	
	private void stop() {
		mp.stop();
		pause.setEnabled(false);
		stop.setEnabled(false);
		
		try {
			mp.prepare();
			mp.seekTo(0);
			play.setEnabled(true);
		}
		catch (Throwable t) {
			goBlooey(t);
		}
	}
	
	private void pause() {
		mp.pause();
		
		play.setEnabled(true);
		pause.setEnabled(false);
		stop.setEnabled(true);
	}
	
	private void loadClip(){
		try{
			mp=MediaPlayer.create(this, R.raw.sehat);
			mp.setOnCompletionListener(this);
		}
	catch (Throwable t){
		goBlooey(t);
	}
	}
	

		
	private void setup(){
		loadClip();
		play.setEnabled(true);
	}
	
	private void goBlooey(Throwable t){
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder
				.setTitle("Exception!")
				.setMessage(t.toString())
				.setPositiveButton("OK", null)
				.show();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play1, menu);
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
}