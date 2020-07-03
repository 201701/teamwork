package dao;

import SQL.SignListSql;

import SQL.SignRecordSql;
import entity.LeaveRecord;
import entity.Sign;
import entity.SignRecord;
import entity.User;
import model.Leave;
import util.DateUtil;
import util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SignRecordDao2 {

    private Connection conn;
    private DbUtil dbConn;
    public SignRecordDao2(){
        this.dbConn=new DbUtil();
    }

    /*鎴愬姛绛惧埌锛屽悜绛惧埌璁板綍椤逛腑娣诲姞涓�鏉＄鍒拌褰�*/
    public void addSignRecord(Date signDate, Time beginTime, Time endTime, User user){
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(SignRecordSql.addSignRecord);
            System.out.println("------鑺傜偣2:SignRecordDao鎵ц-------");
            System.out.println(user.getUserID()+"---"+user.getName()+"----"+signDate+"---"+beginTime+"---"+endTime);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getName());
            ps.setDate(3, signDate);
            ps.setTime(4, beginTime);
            ps.setTime(5, endTime);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }

    public List<SignRecord> searchUserSign(User user, Date today){
        SignRecord signRecord = null;
        List<SignRecord> list = new ArrayList<>();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(SignRecordSql.searchUserSignRecordToday);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getName());
            ps.setDate(3, today);
            rs = ps.executeQuery();
            while (rs.next()){
                signRecord = new SignRecord(rs.getInt("userID"), rs.getString("name"), rs.getDate("signDate"),
                        rs.getTime("beginTime"), rs.getTime("endTime"));
                list.add(signRecord);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
//    	LeaveRecord leaveRecord = null;
//    	List<LeaveRecord> list = new ArrayList<>();
//        conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            this.conn = dbConn.getConnection();
//            ps = (PreparedStatement) conn.prepareStatement("select * from signrecordlist,leaverecordlist where userID=? and name=? and signDate=? signrecordlist.userID = leaverecordlist.userID and signrecordlist.beginTime = leaverecordlist.beginTime and signrecordlist.signDate = leaverecordlist.signDate");
//            ps.setInt(1, user.getUserID());
//            ps.setString(2, user.getName());
//            ps.setDate(3, today);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//            	leaveRecord = new LeaveRecord(rs.getInt("userID"), rs.getString("name"), rs.getDate("signDate"),rs.getTime("beginTime"), rs.getTime("endTime"),rs.getString("reason"),rs.getInt("state"));
//            	list.add(leaveRecord);        
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }

}
