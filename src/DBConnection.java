import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

//Singleton Design Patten
public class DBConnection {


    private static final String userName = "";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static Connection connection;
    private static DBConnection dbConnection;

    private DBConnection() {
    }

    public static DBConnection getInstance() throws SQLException {
        if (Objects.isNull(dbConnection)) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    //method for sqlConnection
    public  Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
