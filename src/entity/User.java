package entity;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class User {
    private int userID;
    private String name;
    private int signCount;

    public User(){

    }

    public User(int userID, String name, int signCount){
        this.userID = userID;
        this.name = name;
        this.signCount = signCount;
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

    public int getSignCount() {
        return signCount;
    }

    public void setSignCount(int signCount) {
        this.signCount = signCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", signCount=" + signCount +
                '}';
    }
}
