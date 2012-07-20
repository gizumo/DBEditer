package jp.android.editer;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Tablelist extends Activity{
	ListView registrantListView;
	private List<String> recelgistDatalist = new ArrayList<String>();
	
	Button menucancel;
	
	TextView Table_name;
	
	private List<RegistData> registlist;
	
	protected void onCreate(Bundle SavedInstanceState){
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.tablelistview);
		
		menucancel=(Button)findViewById(R.id.menuback);
		menucancel.setOnClickListener(new list());
		registrantListView=(ListView)findViewById(R.id.registlistview);
		
		Intent intent=getIntent();
		
		RegistDataList rd=(RegistDataList )intent.getSerializableExtra("RegistDataList");
		for(RegistData registdata:registlist){
			recelgistDatalist .add(ShowString(registdata));
		}
		registrantListView =(ListView )findViewById(R.id.registlistview);
		ArrayAdapter <String> arrayAdapter=new ArrayAdapter<String>(this, R.layout.listview,recelgistDatalist);
		registrantListView.setAdapter(arrayAdapter);
		
	}
	
	class list implements OnClickListener {

		@Override
		public void onClick(View v) {
			finish();
			
		}
		
	}
	
	public String ShowString(RegistData registdata){
		String name=registdata .getName();
		
		String sb="";
		sb=name;
		return sb.toString();
	}
}
