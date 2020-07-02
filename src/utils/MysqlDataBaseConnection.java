package utils;

import java.sql.*;

public class MysqlDataBaseConnection implements DataBaseConnection {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/remotefiletransfer";
    public static final String USER = "root";
    public static final String PASSWORD = "zyily,";

    private Connection conn = null;

    public MysqlDataBaseConnection() {
        try {
            Class.forName(DRIVER);
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Connection getConnection() {
        return this.conn;
    }

    @Override
    public void close() {
        if(this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //增、删、改
    public static int execOther(Connection conn, String sql, Object[] arr) {
        System.out.println("SQL:>" + sql);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                ps.setObject(i + 1, arr[i]);
            }
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //查
    public static ResultSet execQuery(Connection conn, String sql, Object[] arr) {
        System.out.println("SQL:>" + sql);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                ps.setObject(i + 1, arr[i]);
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
