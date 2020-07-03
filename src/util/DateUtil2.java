package util;
import java.sql.Date;

public class DateUtil2 {
	public static java.sql.Date UdateToSqdate(java.util.Date date) {
		java.sql.Date sqdate = new java.sql.Date(date.getTime());
		return sqdate;
		
	}
}
