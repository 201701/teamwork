package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import SQL.SignRecordSql;
import entity.User;
import model.Leave;
import model.SignRecord;
import util.DateUtil;



public class LeaveDao {
	
	/*
	 * 数据库增加一个请假记录
	 */
	public void doLeave(Leave leave) throws ParseException {
		java.sql.Time beginTime =  DateUtil.stringToTime(leave.getBeginTime());
		java.sql.Time endTime =  DateUtil.stringToTime(leave.getEndTime()); 
    	java.sql.Date signDate =  DateUtil.stringToUdate(leave.getSignDate());
		try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into leaverecordlist values(null,?,?,?,?,?,?,?)");
            ps.setInt(1, leave.getUserID());
            ps.setString(2, leave.getName());
            ps.setTime(3, beginTime); 
            ps.setTime(4, endTime);
            ps.setString(5, leave.getReason()); 
            ps.setInt(6, leave.getState());
            ps.setDate(7, signDate);
            
            ps.execute();
            

        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }
  
	/*
	 * 管理员请假页面展示
	 */
	public List<Leave> listLeave() {  	
    	List<Leave> leaves = new ArrayList<Leave>();
        try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from leaverecordlist");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Leave leave = new Leave();
                int id = rs.getInt("id");
                int userID = rs.getInt("userID");
                String name = rs.getString("name");
                String beginTime = rs.getString("beginTime");
                String endTime = rs.getString("endTime");
                String signDate = rs.getString("signDate");
                String reason = rs.getString("reasonForLeave");
                int state = rs.getInt("state");
                leave.setId(id);
                leave.setUserID(userID);
                leave.setName(name);
                leave.setBeginTime(beginTime);
                leave.setEndTime(endTime);
                leave.setSignDate(signDate);
                leave.setReason(reason);
                leave.setState(state);
                leaves.add(leave);         
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaves;
	}
	
	/*
	 * 修改请假状态
	 */
	public void updateTo1(int userID) {
		try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update leaverecordlist set state = ? where userID = ?");
//            ResultSet rs = ps.executeQuery();
            
            ps.setInt(1, 1);
            ps.setInt(2, userID);
            ps.execute();
         
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
	}
	public void updateTo2(int userID) {
		try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update leaverecordlist set state = ? where userID = ?");
//            ResultSet rs = ps.executeQuery();
            
            ps.setInt(1, 2);
            ps.setInt(2, userID);
            ps.execute();
         
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
	}
	
	/*
	 * 获取请假状态
	 */
	public int getState(int userID,String sbeginTime,String sendTime,String ssignDate) throws ParseException {
		int state = -1;
		java.sql.Time beginTime =  DateUtil.stringToTime(sbeginTime);
    	java.sql.Time endTime =  DateUtil.stringToTime(sendTime);   
    	java.sql.Date signDate = DateUtil.stringToUdate(ssignDate);
		try {
            Connection conn = BaseDao.getConnection();
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from leaverecordlist where userID = ? and beginTime = ? and endTime = ? and signDate = ?");
            ps.setInt(1, userID); 
            ps.setTime(2, beginTime);
            ps.setTime(3, endTime);
            ps.setDate(4, signDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	state = rs.getInt("state");
            }
		}catch (SQLException e) {
  
            e.printStackTrace();
        }
		return state;
	}
	
//    public List<SignRecord> searchUserSign(User user, Date today){
//    	List<Leave> leaves = new ArrayList<Leave>();
//    	Date date = new Date();
//        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
//        String today1 = adf.format(date);
//        try {
//            Connection conn = BaseDao.getConnection();
//            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("select * from leaverecordlist where userID = ? and beginTime = ? and endTime = ? and signDate = ?");
//            ps.setInt(1, user.getUserID());
//            ps.setString(2, user.getName());
//            ps.setDate(3, today);
//            
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//            	Leave leave = new Leave();
//                int id = rs.getInt("id");
//                int userID = rs.getInt("userID");
//                String name = rs.getString("name");
//                String beginTime = rs.getString("beginTime");
//                String endTime = rs.getString("endTime");
//                String signDate = rs.getString("signDate");
//                String reason = rs.getString("reasonForLeave");
//                int state = rs.getInt("state");
//                leave.setId(id);
//                leave.setUserID(userID);
//                leave.setName(name);
//                leave.setBeginTime(beginTime);
//                leave.setEndTime(endTime);
//                leave.setSignDate(signDate);
//                leave.setReason(reason);
//                leave.setState(state);
//                leaves.add(leave);     
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return list;
//
//    }
}
