package com.bd.lagusong;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageButton;
import android.media.MediaPlayer;
import android.view.Menu;
import android.view.MenuItem;

public class Play extends ActionBarActivity implements MediaPlayer.OnCompletionListener {
	public final static String Krm_Param = "com.bd.lagusong.MESSAGE"; 
	private ImageButton play;
	private ImageButton pause;
	private ImageButton stop;
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
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