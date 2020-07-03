package service;

import entity.User;

import java.util.List;

public interface UserService {
    public int login(int userID, String uname);

    public List<User> listAllUsers();

    public void addUser(int userID, String name, int i);

    public void deleteUser(int userID, String name);

    public void updateUser(int userID2, String name2, int userID, String name);
}
