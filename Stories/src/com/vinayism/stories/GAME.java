package com.vinayism.stories;

import java.util.Random;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lovestories.R;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class GAME extends Activity implements OnClickListener {

	int min = 65;
	int max = 100;
	NotificationManager nm;
	static final int uniqueID = 4567567;
	TextView textGenerateNumber;
	String field_et;
	EditText field;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.random);

		

		Button buttonGenerate = (Button) findViewById(R.id.generate);
		
		
		field = (EditText)findViewById(R.id.editText1);
		textGenerateNumber = (TextView) findViewById(R.id.generatenumber);
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		nm.cancel(uniqueID);

		buttonGenerate.setOnClickListener(this);
        
		field_et = field.getText().toString().trim();
	}

	
	@Override
    public void onClick(View arg) {
		// TODO Auto-generated method stub
		
		if(field.length()== 0)  // use can use null or isempty function also
		{
			
			Toast.makeText(this, "Edit Field Is Empty",
                    Toast.LENGTH_LONG).show();
		}
		else
		{
		final Random r = new Random();
		
		
		int x = r.nextInt(max - min) + min;
		textGenerateNumber.setText(String.valueOf(x));
		textGenerateNumber.setTextColor(Color.RED);
		
		Intent intent = new Intent(this , GAME.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
		String b = textGenerateNumber.getText().toString();
		String d = "Your Love Percentage Is:";
		String body = d + " " +b;
		String title = "LOVE";
		Notification n = new Notification(R.drawable.ic_launcher , body , System.currentTimeMillis());
		n.setLatestEventInfo(this, title, body, pi);
		n.defaults = Notification.DEFAULT_ALL;
		
		nm.notify(uniqueID , n);
		finish();
		}
	}
	 
}
