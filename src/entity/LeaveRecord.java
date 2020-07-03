package entity;

import java.sql.Time;
import java.util.Date;

public class LeaveRecord {
	 	private int userID;
		private String name;
	    private Date signDate;
	    private Time beginTime;
	    private Time endTime;
	    private String reason;
		private int state;
		
		public LeaveRecord(int userID, String name, Date signDate, Time beginTime, Time endTime,String reason,int state) {
	        this.userID = userID;
	        this.name = name;
	        this.signDate = signDate;
	        this.beginTime = beginTime;
	        this.endTime = endTime;
	        this.reason = reason;
	        this.state = state;
	    }
		
		public int getUserID() {
			return userID;
		}
		public String getName() {
			return name;
		}
		public Date getSignDate() {
			return signDate;
		}
		public Time getBeginTime() {
			return beginTime;
		}
		public Time getEndTime() {
			return endTime;
		}
		public String getReason() {
			return reason;
		}
		public int getState() {
			return state;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setSignDate(Date signDate) {
			this.signDate = signDate;
		}
		public void setBeginTime(Time beginTime) {
			this.beginTime = beginTime;
		}
		public void setEndTime(Time endTime) {
			this.endTime = endTime;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public void setState(int state) {
			this.state = state;
		}
}
