package com.smartken.kia.core.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.smartken.kia.core.model.impl.BaseModel;
import com.smartken.kia.core.util.ObjectUtil;

import jxl.HeaderFooter;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import jxl.write.biff.WritableWorkbookImpl;

public class WorkbookModel {

	private File excel;
	private WritableWorkbook workbook;
	private WritableSheet sheet;
	
	public WorkbookModel(String excelPath) throws IOException{
		    getExcelFile(excelPath);
			this.workbook=Workbook.createWorkbook(excel);	
	}
	
	public WorkbookModel(String excelPath,WorkbookSettings ws) throws IOException{
		getExcelFile(excelPath);
		this.workbook=Workbook.createWorkbook(excel,ws);

	}
	
	private void getExcelFile(String excelPath) throws IOException{
		excel=new File(excelPath);
		if(!excel.exists()){
			excel.createNewFile();
		}
		if(excel.isDirectory()){
			throw new IOException();
		}
	}
	
	public void openSheet(String sheetName){
        this.sheet=this.workbook.getSheet(sheetName);
        if(this.sheet==null){
        	this.sheet=this.workbook.createSheet(sheetName, this.workbook.getNumberOfSheets());
        }
	}

    public  void setHeader(String left,String center,String right){    
    	HeaderFooter hf = new HeaderFooter();    
        hf.getLeft().append(left);    
        hf.getCentre().append(center);    
        hf.getRight().append(right);    
        //加入页眉    
        this.sheet.getSettings().setHeader(hf);    
        //加入页脚    
        //dataSheet.getSettings().setFooter(hf);    
    }
    
   public  void writeSheetData(List<? extends BaseModel> list,int rowStartIndex,int colStartIndex){
	   if(list.size()==0)return;
	   BaseModel bm=list.get(0);
	   Enum[] ens=bm.enumFields();
	   List<String> fields=new ArrayList<String>();
	   for(int i=0;i<ens.length;i++ ){
		   Enum en=ens[i];
		   fields.add(en.name());
		   int rowIndex=rowStartIndex;
		   int colIndex=colStartIndex+i;
		   Label title=new Label(colIndex, rowIndex, en.name());
		   try {
			this.sheet.addCell(title);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   for(int i=0;i<list.size();i++){
		   int rowIndex=i+rowStartIndex+1;
		   BaseModel baseModel=list.get(i);
		   List<WritableCell> cells=createExcelRow(baseModel, rowIndex, colStartIndex,fields);
		   for(WritableCell cell :cells){
			   try {
				this.sheet.addCell(cell);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	   }
	   try {
		this.workbook.write();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public void closeWorkbook(){
	   if(this.workbook==null)return;
	   try {
		this.workbook.close();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   public static List<WritableCell> createExcelRow(BaseModel baseModel,int rowIndex,int colStartIndex,List<String> fields){
	   List<WritableCell> cells=new ArrayList<WritableCell>();
	   WritableCell cell;
	   Type type;
	   Object value;
	   for(int i=0;i<fields.size();i++){
		   String field=fields.get(i);
		   int colIndex=i+colStartIndex;
		   try {
			
			value=baseModel.eval(field);
			if(value==null)continue;
			type=baseModel.type(field);
			if(ObjectUtil.isInArray(type, 
			  new Class[]{Integer.class,Double.class,BigDecimal.class,Float.class}
			)){		   
			   String strValue=value.toString();
			   Double dblValue=Double.parseDouble(strValue);
			   cell=new Number(colIndex, rowIndex, dblValue);

			}else if(ObjectUtil.isInArray(type, 
			  new Class[]{Date.class,Timestamp.class}
			)){
				cell=new DateTime(colIndex, rowIndex, (Date)value);
			}else{
				cell=new Label(colIndex, rowIndex, value.toString());
			}
			cells.add(cell);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   return cells;
   } 
   
   public byte[] toBytes(){
		FileInputStream fis;
		byte[] bytes=null;
		try {
			fis = new FileInputStream(excel);
			bytes=new byte[fis.available()];
			fis.read(bytes);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bytes;
   }
	
}
