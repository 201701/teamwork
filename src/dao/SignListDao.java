package dao;

import SQL.SignListSql;

import entity.Sign;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SignListDao {
    private Connection conn;
    private DbUtil dbConn;
    public SignListDao(){
        this.dbConn=new DbUtil();
    }

    /*绠＄悊鍛樻坊鍔犵鍒伴」*/
    public void addSign(Date date, Time time1, Time time2) {
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(SignListSql.addSign);
            ps.setString(1, String.valueOf(date));
            ps.setString(2, String.valueOf(time1));
            ps.setString(3, String.valueOf(time2));
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }

    public List<Sign> listAllSignsByToday(String today) {
        Sign sign = null;
        List<Sign> list = new ArrayList<>();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            //鎸夌収褰撳墠骞存湀鏃ュ皢瀵瑰簲鐨勬墍鏈夌鍒伴」浠庢暟鎹簱涓煡璇㈠嚭鏉ユ斁鍏ist闆嗗悎涓�
            ps = conn.prepareStatement(SignListSql.listAllSignsByToday);
            ps.setString(1,today);
            rs = ps.executeQuery();
            while (rs.next()){
                sign = new Sign(rs.getDate("signDate"), rs.getTime("beginTime"), rs.getTime("endTime"));
                list.add(sign);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public List<Sign> listAllSigns() {
        Sign sign = null;
        List<Sign> list = new ArrayList<>();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            //鎶婃墍鏈夌鍒伴」浠庢暟鎹簱涓煡璇㈠嚭鏉ユ斁鍏ist闆嗗悎涓�
            ps = conn.prepareStatement(SignListSql.listAllSigns);
            rs = ps.executeQuery();
            while (rs.next()){
                sign = new Sign(rs.getDate("signDate"), rs.getTime("beginTime"), rs.getTime("endTime"));
                list.add(sign);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void deleteSign(Date date, Time time1, Time time2) {
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(SignListSql.deleteSign);
            ps.setDate(1, (java.sql.Date) date);
            ps.setTime(2, time1);
            ps.setTime(3, time2);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }

    public void updateSign(Date date, Time time1, Time time2, Date dateNew, Time time1New, Time time2New) {
        conn = null;
        PreparedStatement ps = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(SignListSql.updateSign);
            ps.setDate(1, (java.sql.Date) dateNew);
            ps.setTime(2, time1New);
            ps.setTime(3, time2New);
            ps.setDate(4, (java.sql.Date) date);
            ps.setTime(5, time1);
            ps.setTime(6, time2);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }
}
