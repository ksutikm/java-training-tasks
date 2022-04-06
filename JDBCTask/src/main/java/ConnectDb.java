import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private static final String user = "postgres";
    private static final String password = "masterkey";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return conn;
    }
}
