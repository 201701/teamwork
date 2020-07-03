package util;

import java.sql.*;

public class DbConn {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/signsystem";
    private final String USERNAME = "root";
    private final String PASSWORD ="";
    private Connection conn=null;

    public DbConn() {
        try{
            Class.forName(DRIVER);
            this.conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void closeConnection(Connection conn) {
        if(conn!=null)
        {
            try{
                conn.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 关闭预处理结果
     */
    public void closePreparedStatement(PreparedStatement ps) {
        if(ps!=null)
        {
            try{
                ps.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集
     */
    public void closeResultSet(ResultSet rs) {
        if(rs!=null)
        {
            try{
                rs.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
