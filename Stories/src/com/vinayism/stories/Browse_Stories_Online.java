package com.vinayism.stories;




import com.example.lovestories.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Browse_Stories_Online extends Activity implements OnClickListener {
	EditText url;
	WebView ourbrow;
	ProgressBar progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);  // progress bar support
		setContentView(R.layout.browsestories);
		
		ourbrow = (WebView) findViewById(R.id.wvbrowser);
		progress =(ProgressBar)findViewById(R.id.progressBar1);
		
		getWindow().setFeatureInt( Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);   //make progressbar visible
		
		ourbrow.setWebViewClient(new Ourviewpage()); // to open link in same browser
		ourbrow.getSettings().setJavaScriptEnabled(true);
		ourbrow.getSettings().setSupportZoom(true); 
		ourbrow.getSettings().setLoadWithOverviewMode(true);
		ourbrow.getSettings().setBuiltInZoomControls(true);
		ourbrow.getSettings().setUseWideViewPort(true);
		try{
		ourbrow.loadUrl("http://www.readanybook.com/");
		}
		catch (Exception e){
			e.getStackTrace();
		}
		
		
	       // This makes the Progress bar be updated.
	       final Activity MyActivity = this;
	       ourbrow.setWebViewClient(new WebViewClient() {
	        public void onProgressChanged(WebView view, int progress)   
	        {
	         //Make the bar disappear after URL is loaded, and changes string to Loading...
	         MyActivity.setTitle("Loading...");
	         MyActivity.setProgress(progress * 100); //Make the bar disappear after URL is loaded
	 
	         
	          }
	        });
		
		
		
		Button go = (Button) findViewById(R.id.bgo);
		Button goback = (Button) findViewById(R.id.bgoback);
		Button goforw = (Button) findViewById(R.id.bgoforward);
		Button refresh = (Button) findViewById(R.id.brefreshpage);
		Button clear = (Button) findViewById(R.id.bclearhistory);
		url = (EditText) findViewById(R.id.etURL);
		go.setOnClickListener(this);
		goback.setOnClickListener(this);
		goforw.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bgo:
			String thewebsite = url.getText().toString();
			ourbrow.loadUrl(thewebsite);
			// hideing keyboard after edit text
		    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); 
		    imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bgoforward:
			if (ourbrow.canGoForward())
				;
			ourbrow.goForward();
			break;
		case R.id.bgoback:
			if (ourbrow.canGoBack())
				;
			ourbrow.goBack();
			break;
		case R.id.brefreshpage:
			ourbrow.reload();
			break;
		case R.id.bclearhistory:
			ourbrow.clearHistory();
			break;
		}
	}
	 

}
