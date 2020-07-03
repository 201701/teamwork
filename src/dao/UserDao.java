package dao;

import SQL.SignListSql;
import SQL.UserSql;
import entity.Sign;
import entity.User;
//import util.DbConn;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {
    private Connection conn;
//    private DbUtil dbConn;
   
    private DbUtil dbConn;
    
    public UserDao(){
        this.dbConn=new DbUtil();
    }

    public User selectUser(int userID) {
        User user = new User();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 获取数据库连接Connection对象
        DbUtil dbConn = new DbUtil();
        try{
            //调用链接数据库的方法
            this.conn = dbConn.getConnection();
            // 获取PreparedStatement对象
            ps = conn.prepareStatement(UserSql.selectUser);
            //根据用户工号进行查询
            ps.setInt(1,userID);
            // 执行查询获取结果集
            rs = ps.executeQuery();
            // 判断结果集是否有效
            while (rs.next()){
                // 对用户对象属性赋值
                user.setUserID(rs.getInt("userID"));//如果数据库中没有找到这个用户，这里就不会被赋值
                user.setName(rs.getString("name"));
                user.setSignCount(rs.getInt("signCount"));
            }
            // 释放此 ResultSet 对象的数据库和 JDBC 资源
            rs.close();
            // 释放此 PreparedStatement 对象的数据库和 JDBC 资源
            ps.close();
        }catch (Exception ex){
            //打印异常
            ex.printStackTrace();
        }
        return user;
    }


    public List<User> listAllUsers() {
        User user = null;
        List<User> list = new ArrayList<>();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            //把所有用户从数据库中查询出来放入list集合中
            ps = conn.prepareStatement(UserSql.listAllUsers);
            rs = ps.executeQuery();
            while (rs.next()){
                user = new User(rs.getInt("userID"), rs.getString("name"), rs.getInt("signCount"));
                list.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;

    }

    public void addUser(int userID, String name, int i) {
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(UserSql.addUser);
            ps.setInt(1, userID);
            ps.setString(2, name);
            ps.setInt(3, i);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }

    public void deleteUser(int userID, String name) {
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(UserSql.deleteUser);
            ps.setInt(1, userID);
            ps.setString(2, name);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }

    public void updateUser(int userID2, String name2, int userID, String name) {
        conn = null;
        PreparedStatement ps = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(UserSql.updateUser);
            ps.setInt(1, userID2);
            ps.setString(2, name2);
            ps.setInt(3, userID);
            ps.setString(4, name);
            ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return;
    }
}
