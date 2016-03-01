package com.vinayism.stories;

import com.example.lovestories.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ForAReason extends Activity implements OnItemClickListener {
	
	public String[] names = { "CHAPTER1", "CHAPTER2", "CHAPTER3", "CHAPTER4", };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
    
         listView.setAdapter(adapter);
         listView.setOnItemClickListener(this);
	    
			    
	}

	 @Override
	    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		 
	         if(position==0){
	             Intent i = new Intent(this, FARchapter1.class);
	             startActivity(i);
	             Toast.makeText(this, "Chapter1",
		                    Toast.LENGTH_SHORT).show();
	            //Toast.makeText(this, "You pressed the first item in the list",
	                //  Toast.LENGTH_SHORT).show();
	        } 
	         if(position==1){
	             Intent p = new Intent(this, FARchapter2.class);
	             startActivity(p);
	             Toast.makeText(this, "Chapter2",
		                    Toast.LENGTH_SHORT).show();
	            //Toast.makeText(this, "You pressed the first item in the list",
	                //  Toast.LENGTH_SHORT).show();
	        }
	         if(position==2){
	             Intent i = new Intent(this, FARchapter3.class);
	             startActivity(i);
	             Toast.makeText(this, "Chapter3",
		                    Toast.LENGTH_SHORT).show();
	            //Toast.makeText(this, "You pressed the first item in the list",
	                //  Toast.LENGTH_SHORT).show();
	        }
	         if(position==3){
	             Intent i = new Intent(this, FARchapter4.class);
	             startActivity(i);
	             Toast.makeText(this, "Chapter4",
		                    Toast.LENGTH_SHORT).show();
	            //Toast.makeText(this, "You pressed the first item in the list",
	                //  Toast.LENGTH_SHORT).show();
	        }
	         
	             
	         
	    }

	
	
	
	
	
	
}
		

	
	
	
