package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection() throws SQLException {
        switch (Config.getProperty("dbType")) {
            case "oracle" :
                connection = DriverManager.getConnection(Config.getProperty("oracleURL"), Config.getProperty("oracleUsername"), Config.getProperty("oraclePassword"));
                break;
            case  "mysql" :
                // create connection for mysql
                break;
            default:
                connection = null;

        }
    }

    public static List<Map<Object, Object>> executeQuery (String query) throws SQLException {

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);
        ResultSetMetaData metaData = resultSet.getMetaData(); // ==> info about table
        int numberOfColumns = metaData.getColumnCount();  // ==> count of columns
        List<Map<Object, Object>> data = new ArrayList<>();

        while (resultSet.next()) {
            Map<Object, Object> map = new HashMap<>();
            for(int i = 1; i <= numberOfColumns; i++) {
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            data.add(map);
        }

        return data;
    }

    public static void close() throws SQLException {
        if (connection != null) connection.close();
        if (statement != null) statement.close();
        if (resultSet != null) resultSet.close();
    }

}
