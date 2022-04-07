import java.sql.*;

public class StudentSqlRequest implements CrudInterface {
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private static final String username = "postgres";
    private static final String password = "masterkey";

    @Override
    public String read() {
        String sql = "Select id, name, gender, student_number from student";
        String resp = "";

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            resp = getHtml(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    private String getHtml(ResultSet rs) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder()
                .append("<table>\n" +
                        "<tr><th>Id</th>" +
                        "<th>Name</th>" +
                        "<th>Gender</th>" +
                        "<th>Student Number</th></tr><tr>");

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            int studentNumber = rs.getInt(4);
            stringBuilder.append("<td>" + id + "</td>")
                    .append("<td>" + name + "</td>")
                    .append("<td>" + gender + "</td>")
                    .append("<td>" + studentNumber + "</td>");
        }

        return stringBuilder.append("</tr></table>").toString();
    }
}
