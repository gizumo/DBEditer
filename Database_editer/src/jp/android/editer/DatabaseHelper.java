package jp.android.editer;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final String DATABASE_NAME = "data";
	private static final int DATABASE_VERSION = 1;
	private  String COLUMNS[];
	private static String CREATE_DB_TABLE_SQL;	
	private RegistData rd;
	
	
	public void CREATE_DB_TABLE_SQL(){
		for(int i=0;i<COLUMNS.length;i++){
		CREATE_DB_TABLE_SQL+=COLUMNS[i];
		}
	}
	
	public void getCOLUMN(String data){
		this.COLUMNS[0]=rd.getName();
		this.COLUMNS[1]="(";
		for(int i=3;i<=COLUMNS.length ;i++){
		this.COLUMNS[i] =data;
		this.COLUMNS[COLUMNS.length+1]=")";
		}
	}
	
	public String setSQL(String SQL){
		return CREATE_DB_TABLE_SQL ;
	}

	public DatabaseHelper(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		//db.execSQL(CREATE_DB_TABLE_SQL);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ
		db.execSQL(CREATE_DB_TABLE_SQL);
		onCreate(db);
	}


}
