package cn.whooper.domain;

import java.util.List;

public class Page {

	public static int RECORD_PER_PAGE = 5;
	public static int INDEXES=6;
	
	public List data;

	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
	public String getPages(int cur){
		
		StringBuffer s = new StringBuffer();
		for (int i=(cur-1); i<(cur-1)+6; i++){
			s.append(i).append(" ");
		}
		return s.toString();
	}
	
}
