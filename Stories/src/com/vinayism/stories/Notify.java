package com.vinayism.stories;

import com.example.lovestories.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Notify extends Activity implements OnClickListener {

	NotificationManager nm;
	static final int uniqueID = 4567567;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.random);
		Button bnot = (Button)findViewById(R.id.generatenumber);
		bnot.setOnClickListener(this);
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(uniqueID);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this , Notify.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		String body = "You Are %d % In Love ,&R ";
		String title = "LOVE";
		Notification n = new Notification(R.drawable.ic_launcher , body , System.currentTimeMillis());
		n.setLatestEventInfo(this, title, body, pi);
		n.defaults = Notification.DEFAULT_ALL;
		
		nm.notify(uniqueID , n);
		finish();
	}
}

