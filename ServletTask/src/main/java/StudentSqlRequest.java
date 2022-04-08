import java.sql.*;

public class StudentSqlRequest implements CrudInterface {
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private static final String username = "postgres";
    private static final String password = "masterkey";

    @Override
    public String read() {
        String sql = "Select id, name, gender, student_number from student;";
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
    public void add(Student student) {
        String sql = String.format("Insert into student (id, name, gender, student_number) values (%d, '%s', '%s', %d);",
                student.getId(), student.getName(), student.getGender(), student.getStudentNumber());

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student, int id) {
        String sql = getUpdateRequest(student, id);

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "Delete from student where id = " + id + ";";

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getUpdateRequest(Student student, int id) {
        int fieldCount = 0;
        StringBuilder sql = new StringBuilder()
                .append("Update student set ");

        if (student.getId() != -1) {
            sql.append("id = " + student.getId());
            fieldCount++;
        }

        if (student.getName() != "") {
            if (fieldCount != 0) {
                sql.append(", ");
            }
            sql.append(String.format("name = '%s'", student.getName()));
            fieldCount++;
        }

        if (student.getGender() != "") {
            if (fieldCount != 0) {
                sql.append(", ");
            }
            sql.append(String.format("gender = '%s'", student.getGender()));
            fieldCount++;
        }

        if (student.getStudentNumber() != -1) {
            if (fieldCount != 0) {
                sql.append(", ");
            }
            sql.append("student_number = " + student.getStudentNumber());
        }

        return sql.append(" where id = " + id + ";").toString();
    }

    private String getHtml(ResultSet rs) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder()
                .append("<table>\n" +
                        "<tr><th>Id</th>" +
                        "<th>Name</th>" +
                        "<th>Gender</th>" +
                        "<th>Student Number</th></tr>");

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String gender = rs.getString(3);
            int studentNumber = rs.getInt(4);
            stringBuilder.append("<tr><td>" + id + "</td>")
                    .append("<td>" + name + "</td>")
                    .append("<td>" + gender + "</td>")
                    .append("<td>" + studentNumber + "</td></tr>");
        }

        return stringBuilder.append("</table>").toString();
    }
}
