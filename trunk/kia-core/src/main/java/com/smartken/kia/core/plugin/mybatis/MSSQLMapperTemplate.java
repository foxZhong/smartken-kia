package com.smartken.kia.core.plugin.mybatis;

import java.util.ArrayList;

public class MSSQLMapperTemplate extends MapperTemplate {

	public MSSQLMapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes,ArrayList<Integer> precisions){
		super(table,pk,dbCols,dbTypes,precisions);
	}

	public MSSQLMapperTemplate(String table,String pk,ArrayList<String> dbCols,ArrayList<String> dbTypes,ArrayList<Integer> precisions,String idGerner){
		super(table,pk,dbCols,dbTypes,precisions,idGerner);
	}
	

	@Override
	public String getCondition(ColumnTemplate ct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class getSubClass() {
		// TODO Auto-generated method stub
		return this.getClass();
	}

}
