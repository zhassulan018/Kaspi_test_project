package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:mysql://localhost:3306/TASK_DB";
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "12345678";
    private static Connection connection = null;

    public static Connection getConnection() throws Exception{
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection con) throws Exception{
        if(con != null)
            con.close();
    }
}
