package jp.android.editer;

import java.io.InputStream;
import java.io.Serializable;

public class RegistData implements Serializable{

	private static final long serialVersionUID = 1L;
	private int rowid;
	private int idata;
	private String sdata;
	private InputStream blobdata;
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}
	
	public int getInt(){
		return idata;
	}
	
	public void setInt(int data){
		this.idata=data;
	}
	
	public String getString(){
		return sdata;
	}
	
	public void setString(String data){
		this.sdata=data;
	}
	
	public InputStream getBLOB(){
		return blobdata;
	}
	
	public void setBLOB(InputStream data){
		this.blobdata =data;
	}
	
}