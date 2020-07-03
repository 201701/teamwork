package SQL;

public class UserSql {
    //查找用户（即登陆时检查该工号是否存在于数据库）
    public static String selectUser="SELECT*FROM user WHERE userID=?";
//    查找全部用户
    public static String listAllUsers="select * from user";
//    添加用户
    public static String addUser="insert into user(userID, name, signCount)values(?,?,?)";
//    删除用户
    public static String deleteUser="delete from user where userID=? and name=?";
//    修改用户信息
    public static String updateUser="update user set userID=? , name=?  where userID=?  and name=?";
}
