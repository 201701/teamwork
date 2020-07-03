package util;

import java.util.Date;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	
	/**
	 * 
	 * @param sDate
	 * @return	java.sql.Date格式的
	 * @throws ParseException
	 */
	public static java.sql.Date stringToUdate(String sDate) throws ParseException {
		SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd");
	    Date stDate=sdf1.parse(sDate);       
	    java.sql.Date startDate=new java.sql.Date(stDate.getTime());
System.out.println("sql.Date:"+startDate);
		return startDate;
	}
	
	/**
	 * 
	 * @param date
	 * @return	String类型的
	 */
	public static String dateToString(Date date) {
		java.sql.Date date1=new java.sql.Date(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date1);
		return dateString;
	}
	
	/**
	 * 
	 * @param strTime
	 * @return	java.sql.Time类型的
	 */
	public static java.sql.Time stringToTime(String strTime) {  
	    String str = strTime;  
	    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");  
	    java.util.Date d = null;  
	    try {  
	    	d = format.parse(str);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    java.sql.Time time = new java.sql.Time(d.getTime());  
	    return time.valueOf(str);  
	  }  
	
	/**
	 * 
	 * @param time
	 * @return	String类型的
	 */
	public static String timeToString(Time time) {
		
		return time.toString();
	} 
}
