package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    private static Connection getDatabaseConnection() {
        String databaseUrl = PropertyHelper.getProperty("dbUrl");
        String databaseUser = PropertyHelper.getProperty("dbUser");
        String databasePassword = PropertyHelper.getProperty("dbPassword");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(
                            databaseUrl,
                            databaseUser,
                            databasePassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static ResultSet executeQuery(String query) {
        Connection connection = getDatabaseConnection();
        ResultSet response = null;
        try {
            response = connection.prepareStatement(query).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static List<String> getDuckNames() throws SQLException {
        String query = "SELECT name FROM `lc_products_info`";
        ResultSet rs = executeQuery(query);
        List<String> result = new ArrayList<>();

        while (rs.next()) {
            result.add(rs.getString("name"));
        }

        return result;
    }

}

