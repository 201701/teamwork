package SQL;

import java.sql.Time;
import java.util.Date;

public class SignListSql {
    public static String addSign="insert into signlist(signDate, beginTime, endTime)values(?,?,?)";
    public static String listAllSignsByToday="select signDate, beginTime, endTime from signlist where signDate=?";
//    public static String listAllSigns="select signDate, beginTime, endTime from signlist";
    public static String listAllSigns="select * from signlist";
   
    public static String deleteSign="delete from signlist where signDate=? and beginTime=? and endTime=?";
    public static String updateSign="update signlist set signDate=? , beginTime=? , endTime=? where signDate=? and beginTime=? and endTime=?";
}
