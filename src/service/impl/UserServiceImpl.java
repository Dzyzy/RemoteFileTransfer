package service.impl;

import service.UserService;
import pojo.User;
import utils.DaoFactory;
import utils.DataBaseConnection;
import utils.DataBaseConnectionFactory;

public class UserServiceImpl implements UserService {
    private DataBaseConnection dataBaseConnection;

    public UserServiceImpl() {
        dataBaseConnection = DataBaseConnectionFactory.getDataBaseConnection();
    }


    @Override
    public boolean insertUser(User user) {
        try {
            return DaoFactory.getUserDaoInstance(dataBaseConnection.getConnection()).insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dataBaseConnection.close();
        }
        return false;
    }

    @Override
    public boolean findUserById(String userId) {
        try {
            return DaoFactory.getUserDaoInstance(dataBaseConnection.getConnection()).findUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dataBaseConnection.close();
        }
        return false;
    }

    @Override
    public boolean updateUserPassword(String userId, String userPassword) {
        try {
            return DaoFactory.getUserDaoInstance(dataBaseConnection.getConnection()).updateUserPassword(userId, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dataBaseConnection.close();
        }
        return false;
    }

    @Override
    public boolean findUserPasswordById(String userId, String userPassword) {
        try {
            return DaoFactory.getUserDaoInstance(dataBaseConnection.getConnection()).findUserPasswordById(userId, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dataBaseConnection.close();
        }
        return false;
    }

    @Override
    public User findUserInformation(String userId) {
        try {
            return DaoFactory.getUserDaoInstance(dataBaseConnection.getConnection()).findUserInformation(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.dataBaseConnection.close();
        }
        return null;
    }
}
