package SQL;

public class SignRecordSql {
    public static String addSignRecord="insert into signrecordlist(userID, name, signDate, beginTime, endTime)values(?,?,?,?,?)";
    public static String searchUserSignRecordToday="select * from signrecordlist where userID=? and name=? and signDate=?";
}
