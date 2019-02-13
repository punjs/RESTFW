package com.sandeep.RESTFW.POJOClasses;

import java.util.ArrayList;

public class test {
	private String object;
	  ArrayList<Object> data = new ArrayList<Object>();
	  private boolean has_more;
	  private String url;
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public ArrayList<Object> getData() {
		return data;
	}
	public void setData(ArrayList<Object> data) {
		this.data = data;
	}
	public boolean isHas_more() {
		return has_more;
	}
	public void setHas_more(boolean has_more) {
		this.has_more = has_more;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
