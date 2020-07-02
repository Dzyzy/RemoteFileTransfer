package utils;

public class DataBaseConnectionFactory {
    public static DataBaseConnection getDataBaseConnection() {
        return new MysqlDataBaseConnection();
    }
}
