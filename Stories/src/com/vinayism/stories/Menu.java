package com.vinayism.stories;

import com.example.lovestories.R;
import com.vinayism.stories.Menu;




import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends ListActivity   {
	
	String classes[] = {"ForAReason","An_IITian_Story","Love_Is_Invisible" ,"My_Best_Friend" , "A_Love" ,"Browse_Stories_Online" , "GAME" };

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setListAdapter(new ArrayAdapter<String>(Menu.this, 
				android.R.layout.simple_list_item_1,classes));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String cheese = classes[position];
		try{
		Class ourClass = Class.forName("com.vinayism.stories."+cheese);
		Intent ourIntent = new Intent(Menu.this,ourClass);
		startActivity(ourIntent);
		
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	

}

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.cool_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutus:
			Toast.makeText(this, "ABOUT ME", Toast.LENGTH_SHORT).show();
			Intent i = new Intent("com.example.lovestories.ABOUTUS");
			startActivity(i);
			break;
		case R.id.setting:
			Toast.makeText(this, "SETTING", Toast.LENGTH_SHORT).show();
			Intent p = new Intent("com.example.lovestories.SETTING");
			startActivity(p);
			break;
		case R.id.exit: 
			Toast.makeText(this, "EXIT", Toast.LENGTH_SHORT).show();
			finish();
		}
		return false;
	}

	
	


}
