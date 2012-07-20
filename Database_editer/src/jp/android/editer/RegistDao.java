package jp.android.editer;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RegistDao {
	
	private SQLiteDatabase db;
	private DatabaseHelper dh;
	
	private static final String TABLE_SERCH="PRAGMA TABLE_INFO(CREATE_SCHEDULE_TABLE_SQL)";
	private static final String TABLE_NAME="DB";
	private static final String COLUMN_ID="rowid";
	private static final String COLUMNS[]=
	{null,null,COLUMN_ID};
	
	public String[] ReCOLUMNS(){
		return COLUMNS;
	}
	
	public  void TABLE_SERCH(){
		for(int i=2;i<=COLUMNS.length-1;i++){
		}
	}

	public RegistDao(SQLiteDatabase db) {
		this.db = db;
	}
	
	public long Insert(RegistData registdata){
		ContentValues values=new ContentValues();
		return db.insert(TABLE_NAME, null, values);
	}
	
	public int update(RegistData registdata){
		ContentValues values = new ContentValues();
		String whereClause="rowid="+registdata.getRowid();
		return db.update(TABLE_NAME, values, whereClause, null);
	}
	
	public RegistData findById(int rowId) {
		String selection = "rowid = " + rowId;
		Cursor cursor =
			db.query(TABLE_NAME, COLUMNS, selection, null, null, null, null);

		while(cursor.moveToNext()) {
			RegistData registData = new RegistData();
			registData.setRowid(cursor.getInt(0));
			return registData;
		}

		// レコードが見つからない場合、nullを返す
		return null;
	}
	
	/*
	 * 全レコード削除
	 */
	public void deleteAll(String tableName) {

		db.delete(tableName, null, null);
		//db.close();
	}

	/*
	 * 行番号のレコードを削除処理
	 */
	public int delete(int rowId) {

		String whereClause = "rowid = " + rowId;
		return db.delete(TABLE_NAME, whereClause, null);
	}

	public List<RegistData> findAll() {
		List<RegistData> addressDataList = new ArrayList<RegistData>();

		
		//Cursor cursor = db.query(TABLE_NAME, COLUMNS, null, null, null, null, COLUMN_NAME);
		return null;
	}

}
