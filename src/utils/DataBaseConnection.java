package utils;

import java.sql.Connection;

public interface DataBaseConnection {
    Connection getConnection();
    void close();
}
