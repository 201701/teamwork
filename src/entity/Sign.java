package entity;

import java.sql.Time;
import java.util.Date;

public class Sign {
    private Date signDate;
    private Time beginTime;
    private Time endTime;

    public Sign(Date signDate, Time beginTime, Time endTime) {
        this.signDate = signDate;
        this.beginTime = beginTime;
        this.endTime = endTime;
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
