package serviceImpl;

import dao.UserDao;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int login(int userID, String uname) {
        UserDao userDao = new UserDao();
        User user = userDao.selectUser(userID);
        // 判断user是否为空
        if(user.getUserID()!=0) {
System.out.println("~~~~~~~~~~~~~~"+user.getUserID()+"~~~~~~~~~~~~~~~~~");
            //判断用户输入的名字是否正确
            if (user.getName().equals(uname)){
                /*用户输入的工号和名字对应数据库中的一个用户信息*/
                /*根据工号判断是否为管理员登录*/
                if(userID==200000)
                    return 2;
                else
                    return 1;
            }
            /*用户名不一致登录失败*/
            else {
                return 0;
            }
        }
        /*工号错误*/
        else{
            return 0;
        }
    }

    @Override
    public List<User> listAllUsers() {
        UserDao userDao = new UserDao();
        return  userDao.listAllUsers();
    }

    @Override
    public void addUser(int userID, String name, int i) {
        UserDao userDao = new UserDao();
        userDao.addUser(userID, name, i);
    }

    @Override
    public void deleteUser(int userID, String name) {
        UserDao userDao = new UserDao();
        userDao.deleteUser(userID, name);
    }

    @Override
    public void updateUser(int userID2, String name2, int userID, String name) {
        UserDao userDao = new UserDao();
        userDao.updateUser(userID2, name2, userID, name);
    }
}
