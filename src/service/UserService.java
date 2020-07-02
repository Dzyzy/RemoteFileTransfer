package service;

import pojo.User;

public interface UserService {
    //注册用户
    boolean insertUser(User user);

    //判断该账号是否存在
    boolean findUserById(String userId);

    //修改用户密码
    boolean updateUserPassword(String userId, String userPassword);

    //判断账号密码是否正确
    boolean findUserPasswordById(String userId, String userPassword);

    //查找用户信息
    User findUserInformation(String userId);
}
