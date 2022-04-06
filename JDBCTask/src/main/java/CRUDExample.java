import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDExample {
    public static void read() throws SQLException {
        Connection connection = ConnectDb.connect();
        Statement statement = connection.createStatement();
        String sql = "Select id, name, gender, student_number from student";

        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            int studentNumber = rs.getInt(4);
            System.out.println("----------------------------");
            System.out.println("Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Gender: " + gender);
            System.out.println("Student number: " + studentNumber);
        }

        connection.close();
    }

    public static void add() throws SQLException {
        Connection connection = ConnectDb.connect();
        Statement statement = connection.createStatement();
        String sql = "Insert into student (id, name, gender, student_number) values (3, 'John', 'Male', 1114)";

        int rowCount = statement.executeUpdate(sql);
        System.out.print("\n\nEntry added\n\n");
        connection.close();
    }

    public static void update() throws SQLException {
        Connection connection = ConnectDb.connect();
        Statement statement = connection.createStatement();

        String sql = "Update student set name = 'Max' where id = 3";

        int rowCount = statement.executeUpdate(sql);
        System.out.print("\n\nEntry updated\n\n");
        connection.close();
    }

    public static void delete() throws SQLException {
        Connection connection = ConnectDb.connect();
        Statement statement = connection.createStatement();

        String sql = "Delete from student where id = 3;";

        statement.executeUpdate(sql);
        System.out.print("\n\nEntry deleted\n\n");
        connection.close();
    }
}
