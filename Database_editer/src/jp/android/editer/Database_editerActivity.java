package jp.android.editer;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Database_editerActivity extends Activity {
	
	private Button editButton;
	private Button managementButton;
	private Button exitButton;
	
	private RegistDao registDao;
	private SQLiteDatabase db;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DatabaseHelper dbHelper=new DatabaseHelper(this);
		db = dbHelper.getWritableDatabase();
		registDao = new RegistDao(db);
		
		editButton=(Button)findViewById(R.id.editbutton);
		managementButton=(Button)findViewById(R.id.managementbutton);
		exitButton=(Button)findViewById(R.id.exitbutton);
		
		editButton.setOnClickListener(new Edit_ShowOnClick());
		managementButton.setOnClickListener(new management_ShowOnClick());
		exitButton.setOnClickListener(new exit_ShowOnClick());
    }
    
    class Edit_ShowOnClick implements OnClickListener{
		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			intent.setClassName("jp.android.editer", "jp.android.editer.Baseedit");
			startActivity(intent);
		}    	
    }
    
	class management_ShowOnClick implements OnClickListener{
		@Override
		public void onClick(View v) {
			
			List<RegistData> registDataList=registDao.findAll();
			
			
			Intent intent=new Intent();
			intent.setClassName("jp.android.editer", "jp.android.editer.Tablelist");
			startActivity(intent);
		}
	}
	
	class exit_ShowOnClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			finish();
			
		}
		
	}
    
}