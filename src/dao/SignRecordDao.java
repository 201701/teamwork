package dao;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SignRecord;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.DateUtil;
import util.StringUtil;
import model.Page;
import java.sql.Date;


import java.sql.Connection;
import model.SignRecord;

import com.mysql.jdbc.PreparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;



public class SignRecordDao {
    /**
     * @param micro
     * @return
     * @throws SQLException
     */
    // static String sql = "select * from Student where ? = ?";
	
	public static List<SignRecord> getListByDate(String signDate) throws SQLException {

    	List<SignRecord> signRecords = new ArrayList<SignRecord>();

        try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist where name = ?");
            // ps.setString(1, "name");
            ps.setString(1, signDate);
            ResultSet rs = ps.executeQuery();
            // List<Student> list = new ArrayList();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
//                String signDate = rs.getString("signDate");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setSignDate(signDate);
                signRecords.add(signRecord);
            }
            BaseDao.closeCon();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return signRecords;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     * @throws ParseException 
     */
	public static List<SignRecord> getSelectedDate(String signDateString) throws SQLException, ParseException {

    	java.sql.Date signDate =  DateUtil.stringToUdate(signDateString);

    	List<SignRecord> signRecords = new ArrayList<SignRecord>();
        try {
System.out.println("--------------------------------");
System.out.println("signDateString:"+signDateString);
System.out.println("SQL:"+signDate);
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,user where signDate = ? and signrecordlist.userID = user.userID");
            // ps.setString(1, "name");
            
            ps.setDate(1, (java.sql.Date) signDate);
            ResultSet rs = ps.executeQuery();
            // List<Student> list = new ArrayList();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                
                int signCount = rs.getInt("signCount");
                
System.out.println("id:"+id);
System.out.println("user:"+userID);
//                String signDate = rs.getString("signDate");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setName(name);
                String signDateS = DateUtil.dateToString((java.sql.Date) signDate);
                signRecord.setSignDate(signDateS);

                signRecord.setSignCount(signCount);
                
                signRecords.add(signRecord);         
            }

 //           BaseDao.closeCon();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signRecords;
    }
	
    public static List<SignRecord> getSelectedDateOrderByID(String signDateString) throws SQLException, ParseException {

    	java.sql.Date signDate =  DateUtil.stringToUdate(signDateString);

    	List<SignRecord> signRecords = new ArrayList<SignRecord>();
        try {
System.out.println("--------------------------------");
System.out.println("signDateString:"+signDateString);
System.out.println("SQL:"+signDate);
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,user where signDate = ? and signrecordlist.userID = user.userID order by signrecordlist.userID");
            // ps.setString(1, "name");
            
            ps.setDate(1, (java.sql.Date) signDate);
            ResultSet rs = ps.executeQuery();
            // List<Student> list = new ArrayList();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                
                int signCount = rs.getInt("signCount");
                
System.out.println("id:"+id);
System.out.println("user:"+userID);
//                String signDate = rs.getString("signDate");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setName(name);
                String signDateS = DateUtil.dateToString((java.sql.Date) signDate);
                signRecord.setSignDate(signDateS);

                signRecord.setSignCount(signCount);
                
                signRecords.add(signRecord);         
            }

 //           BaseDao.closeCon();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signRecords;
    }

    public static List<SignRecord> getSelectedDateOrderByCount(String signDateString) throws SQLException, ParseException {

    	java.sql.Date signDate =  DateUtil.stringToUdate(signDateString);

    	List<SignRecord> signRecords = new ArrayList<SignRecord>();
        try {
System.out.println("--------------------------------");
System.out.println("signDateString:"+signDateString);
System.out.println("SQL:"+signDate);
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,user where signDate = ? and signrecordlist.userID = user.userID order by signCount desc");
            // ps.setString(1, "name");
            
            ps.setDate(1, (java.sql.Date) signDate);
            ResultSet rs = ps.executeQuery();
            // List<Student> list = new ArrayList();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                
                int signCount = rs.getInt("signCount");
                
System.out.println("id:"+id);
System.out.println("user:"+userID);
//                String signDate = rs.getString("signDate");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setName(name);
                String signDateS = DateUtil.dateToString((java.sql.Date) signDate);
                signRecord.setSignDate(signDateS);

                signRecord.setSignCount(signCount);
                
                signRecords.add(signRecord);         
            }

 //           BaseDao.closeCon();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signRecords;
    }

    public static List<SignRecord> getSelectedTime(String sbeginTime,String sendTime) throws SQLException, ParseException {
    	java.sql.Time beignTime =  DateUtil.stringToTime(sbeginTime);
    	java.sql.Time endTime =  DateUtil.stringToTime(sendTime);    	
    	List<SignRecord> signRecords = new ArrayList<SignRecord>();
        try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,user where beginTime = ? and endTime = ? and signrecordlist.userID = user.userID");
            ps.setTime(1, (java.sql.Time) beignTime);
            ps.setTime(2, (java.sql.Time) endTime);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                int signCount = rs.getInt("signCount");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setName(name);
                String strBeginTime = DateUtil.timeToString((java.sql.Time) beignTime);
                String strEndTime = DateUtil.timeToString((java.sql.Time) endTime);
                signRecord.setBeginTime(strBeginTime);
                signRecord.setEndTime(strEndTime);
                signRecord.setSignCount(signCount);
                signRecords.add(signRecord);         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signRecords;
    }

    public static List<SignRecord> getSelectedTimeOrderByID(String sbeginTime,String sendTime) throws SQLException, ParseException {
    	java.sql.Time beignTime =  DateUtil.stringToTime(sbeginTime);
    	java.sql.Time endTime =  DateUtil.stringToTime(sendTime);    	
    	List<SignRecord> signRecords = new ArrayList<SignRecord>();
        try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,user where beginTime = ? and endTime = ? and signrecordlist.userID = user.userID order by signrecordlist.userID");
            ps.setTime(1, (java.sql.Time) beignTime);
            ps.setTime(2, (java.sql.Time) endTime);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                int signCount = rs.getInt("signCount");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setName(name);
                String strBeginTime = DateUtil.timeToString((java.sql.Time) beignTime);
                String strEndTime = DateUtil.timeToString((java.sql.Time) endTime);
                signRecord.setBeginTime(strBeginTime);
                signRecord.setEndTime(strEndTime);
                signRecord.setSignCount(signCount);
                signRecords.add(signRecord);         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signRecords;
    }
    
    public static List<SignRecord> getSelectedTimeOrderByCount(String sbeginTime,String sendTime) throws SQLException, ParseException {
    	java.sql.Time beignTime =  DateUtil.stringToTime(sbeginTime);
    	java.sql.Time endTime =  DateUtil.stringToTime(sendTime);    	
    	List<SignRecord> signRecords = new ArrayList<SignRecord>();
        try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,user where beginTime = ? and endTime = ? and signrecordlist.userID = user.userID order by signCount desc");
            ps.setTime(1, (java.sql.Time) beignTime);
            ps.setTime(2, (java.sql.Time) endTime);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	SignRecord signRecord = new SignRecord();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                int signCount = rs.getInt("signCount");
                signRecord.setId(id);
                signRecord.setUserID(userID);
                signRecord.setName(name);
                String strBeginTime = DateUtil.timeToString((java.sql.Time) beignTime);
                String strEndTime = DateUtil.timeToString((java.sql.Time) endTime);
                signRecord.setBeginTime(strBeginTime);
                signRecord.setEndTime(strEndTime);
                signRecord.setSignCount(signCount);
                signRecords.add(signRecord);         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signRecords;
    }

    
}