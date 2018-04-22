package com.gasq.bdp.logn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**  
* 类说明   操作excel 的工具类
*  
* @author laody 
* @date 2018年1月16日
*/
public class ExcelUtil {
	public  static final  String EXS = "xls";
	public  static final  String EXSX = "xlsx";
	public  static final  String GENERAL = "General";
	public  static final  String DEFUALTDATEFM="m/d/yy";
	public  static final SimpleDateFormat FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 格式化number String字符
	 */
	public  static final DecimalFormat GENNERALDECIMAL = new DecimalFormat("0");    

	/**
	 * 日期格式化  
	 */
	public  static final SimpleDateFormat DATE = new SimpleDateFormat("yyy-MM-dd");  

	/**
	 *格式化数字  
	 */
	public  static final DecimalFormat SPECIALDECIMAL = new DecimalFormat("0.00");  
	public static Workbook getWorkBook(String extension){

		if(extension.equals(EXS)){
			return new HSSFWorkbook();
		}

		if(extension.equals(EXSX)){
			return new XSSFWorkbook();
		}
		return null;
	}
	
	public static Workbook getWorkBook(String extension,InputStream in) throws IOException{
		if(extension.equals(EXS)){
			return new HSSFWorkbook(in);
		}
		if(extension.equals(EXSX)){
			return new XSSFWorkbook(in);
		}
		return null;
	}
	
	public static  Object getCellValue(Cell cell){
			Object value = null;
	       switch (cell.getCellType()) {  
	        case Cell.CELL_TYPE_STRING:  
	            value = cell.getRichStringCellValue().getString();  
	            break;  
	        case Cell.CELL_TYPE_NUMERIC:  
	            if(GENERAL.equals(cell.getCellStyle().getDataFormatString())){ 
	                value = GENNERALDECIMAL.format(cell.getNumericCellValue());  
	            }else if(DEFUALTDATEFM.equals(cell.getCellStyle().getDataFormatString())){
	                value = DATE.format(cell.getDateCellValue());  
	            }else{
	                value = SPECIALDECIMAL.format(cell.getNumericCellValue());  
	            }  
	            break;  
	        case Cell.CELL_TYPE_BOOLEAN:  
	            value = cell.getBooleanCellValue();  
	            break;  
	        case Cell.CELL_TYPE_BLANK:  
	            value = "";  
	            break;  
	        default:  
	            break; 
	       }
	       return value;
	}

}
