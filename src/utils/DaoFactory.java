package utils;


import dao.UserDao;
import dao.impl.UserDaoImpl;

import java.sql.Connection;

public class DaoFactory {
    public static UserDao getUserDaoInstance(Connection conn) {
        return new UserDaoImpl(conn);
    }
}
