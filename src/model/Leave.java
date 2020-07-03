package model;

public class Leave {
	private int id;
	private int userID;
	private String name;
	private String beginTime;
	private String endTime;
	private String reason;
	private int state;
	private String signDate;
	
	public int getId() {
		return id;
	}
	public int getUserID() {
		return userID;
	}
	public String getName() {
		return name;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public int getState() {
		return state;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
