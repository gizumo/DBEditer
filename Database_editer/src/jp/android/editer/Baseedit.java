package jp.android.editer;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.DhcpInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Baseedit extends Activity{
	
	private EditText SQL;
	private EditText tablename;
	private Button SQL_Button;
	private Button COLUMN_Button;
	private Button menucancel_Button;
	
	private SQLiteDatabase db;
	private String SQLdata;
	private DatabaseHelper  dh;
	private RegistData rd;

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baseedit);
		initspinner();
		
		DatabaseHelper dbHelper=new DatabaseHelper(this);
		db=dbHelper.getWritableDatabase();
		
		tablename =(EditText)findViewById(R.id .tableedit);
		SQL=(EditText)findViewById(R.id.column_name);
		COLUMN_Button =(Button)findViewById(R.id .COLUMN_BUTTON );
		SQL_Button=(Button)findViewById(R.id.SQL＿BUTTON);
		menucancel_Button=(Button)findViewById(R.id.cancel_Button);
		
		COLUMN_Button .setOnClickListener(new COLUMN_buttonOnClick());
		SQL_Button .setOnClickListener(new SQL_buttonOnClick());
		menucancel_Button.setOnClickListener(new menucancelOnClick());
			
		}
	
	
	class COLUMN_buttonOnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			rd.setName(tablename.toString());
			String cltype=(String)findViewById(R.id.Type_spinner).toString();
			if(cltype=="空白(Null)"){
				dh.getCOLUMN(null);
			}
			if(cltype=="数値(Integer)"){
				SQLdata=SQL.getText().toString()+" "+"Integer";
				dh.getCOLUMN(SQLdata);
			}
			if(cltype=="少数含む数値(REAL)"){
				SQLdata=SQL.getText().toString()+" "+"REAL";
				dh.getCOLUMN(SQLdata);
			}
			if(cltype=="文字列(TEXT)"){
				SQLdata=SQL.getText().toString()+" "+"TEXT";
				dh.getCOLUMN(SQLdata);
			}
			if(cltype=="データそのまま(BLOB)"){
				SQLdata=SQL.getText().toString()+" "+"NONE";
				dh.getCOLUMN(SQLdata);
			}
			
		}
		
	}
	
	
	class SQL_buttonOnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			String SQL = null;
			dh.CREATE_DB_TABLE_SQL();
			db.execSQL(dh.setSQL(SQL));
		}
		
	}
	
	class menucancelOnClick implements OnClickListener{
		@Override
		public void onClick(View v) {
			finish();
		}
	}
	
	private void initspinner(){
		Spinner cltype=(Spinner)findViewById(R.id.Type_spinner);
        String[] labels = getResources().getStringArray(R.array.item_label);
        ArrayAdapter<String> adapter
          = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels);
        cltype.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	}
	
}
