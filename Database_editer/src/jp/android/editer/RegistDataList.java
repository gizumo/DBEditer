package jp.android.editer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegistDataList implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private List<RegistData> registDataList = new ArrayList<RegistData>();

	public void setRegistData(RegistData registData) {
		registDataList.add(registData);

	}

	public List<RegistData> getRegistData() {
		return registDataList;
	}
	
}
