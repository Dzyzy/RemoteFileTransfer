package dao.impl;

import dao.UserDao;
import pojo.User;
import utils.MysqlDataBaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private Connection conn = null;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insertUser(User user) {
        String sql = "INSERT INTO user(userid, userpassword, username, usersex, userbirthday, userphone, useremail) VALUES(?, ?, ?, ?, ?, ?, ?)";
        int result = MysqlDataBaseConnection.execOther(conn, sql,
                new Object[]{user.getUserId(), user.getUserPassword(), user.getUserName(), user.getUserSex(), user.getUserBirthday(), user.getUserPhone(), user.getUserEmail()});
        return result > 0;
    }

    @Override
    public boolean findUserById(String userId) throws SQLException {
        String sql = "SELECT * FROM user WHERE userid = ?";
        ResultSet rs = MysqlDataBaseConnection.execQuery(conn, sql,
                new Object[]{userId});
        return rs.next();
    }

    @Override
    public boolean updateUserPassword(String userId, String userPassword) {
        String sql = "UPDATE user SET userpassword=? WHERE userid=?";
        int result = MysqlDataBaseConnection.execOther(conn, sql,
                new Object[]{userPassword, userId});
        return result > 0;
    }

    @Override
    public boolean findUserPasswordById(String userId, String userPassword) throws SQLException {
        String sql = "SELECT userpassword FROM user WHERE userId = ?";
        ResultSet rs = MysqlDataBaseConnection.execQuery(conn,sql,
                new Object[]{userId});
        String password = null;
        while(rs.next()) {
            password = rs.getString("userpassword");
        }
        return userPassword.equals(password);
    }

    @Override
    public User findUserInformation(String userId) throws SQLException {
        String sql = "SELECT * FROM user WHERE userid = ?";
        ResultSet rs = MysqlDataBaseConnection.execQuery(conn, sql,
                new Object[]{userId});
        User user = null;
        while(rs.next()) {
            user = new User(userId, rs.getString("userpassword"), rs.getString("username"),
                    rs.getString("usersex"), rs.getDate("userbirthday"),
                    rs.getString("userphone"), rs.getString("userEmail"));
        }
        return user;
    }
}
