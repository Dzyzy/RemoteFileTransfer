package dao;

import pojo.User;

import java.sql.SQLException;

public interface UserDao {
    //注册用户
    boolean insertUser(User user);

    //判断该账号是否存在
    boolean findUserById(String userId) throws SQLException;

    //修改用户密码
    boolean updateUserPassword(String userId, String userPassword);

    //判断账号密码是否正确
    boolean findUserPasswordById(String userId, String userPassword) throws SQLException;

    //查找用户信息
    User findUserInformation(String userId) throws SQLException;
}
