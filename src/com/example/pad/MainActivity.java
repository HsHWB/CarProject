package com.example.pad;
/**
 * 平板端，小区停车场activity
 */
import java.text.SimpleDateFormat;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	public static int screenWidth;
	private String date = null;//时间更新
	TextView tvTime;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		screenWidth  = getWindowManager().getDefaultDisplay().getWidth();
		setContentView(R.layout.activity_main);
	    tvTime = (TextView)findViewById(R.id.tvTime);//时间textview
		setTimer.schedule(timeTask, 0, 60000);
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
	
	/**
	 * 更新时间
	 */
	private final Timer setTimer = new Timer();
	private TimerTask timeTask = new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Message msg = new Message();
			msg.what = 0x12a;
			setTimeHandler.sendMessage(msg);
		}
	};
	
	private Handler setTimeHandler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			if(msg.what == 0x12a){
				SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");       
				date = sDateFormat.format(new java.util.Date()); 
				tvTime.setText(date);
			}
		}
	};
}
