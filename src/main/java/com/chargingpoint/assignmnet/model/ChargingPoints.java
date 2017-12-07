package com.chargingpoint.assignmnet.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public enum ChargingPoints {

	INSTANCE;
	
	private Map<Integer, String> columnNames = new HashMap<Integer, String>();

	private List<String[]> cpList = new LinkedList<String[]>();
	
	public static final int CPID_NO = 0;
	public static final int LATITUDE_NO = 3;
	public static final int LONGITUDE_NO = 4;
	public static final int NOOFCOLUMNS_READ = 16;
	

	public Map<Integer, String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(Map<Integer, String> columnNames) {
		this.columnNames = columnNames;
	}

	public List<String[]> getCpList() {
		return cpList;
	}

	public void setCpList(List<String[]> inputList) {
		this.cpList = inputList;
	}


}
