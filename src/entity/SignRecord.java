package entity;

import java.sql.Time;
import java.util.Date;

public class SignRecord {
    private int userID;
    private String name;
    private Date signDate;
    private Time beginTime;
    private Time endTime;

    public SignRecord(int userID, String name, Date signDate, Time beginTime, Time endTime) {
        this.userID = userID;
        this.name = name;
        this.signDate = signDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
