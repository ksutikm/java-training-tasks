import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentSqlRequest implements CrudInterface<Student> {
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/test";
    private static final String username = "postgres";
    private static final String password = "masterkey";

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public StudentSqlRequest() {
        students = new ArrayList<>();
    }

    @Override
    public void read() {
        String sql = "Select id, name, gender, student_number from student;";

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                int studentNumber = rs.getInt(4);
                students.add(new Student(id, name, gender, studentNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public String update(Student student, int id) {
        String sql = getUpdateRequest(student, id);

        try(Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
        ) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
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

    private Map<String, Function<Student, String>> getParams() {
        Map<String, Function<Student, String>> params = new HashMap<>();
        params.put("id", Student::getStringId);
        params.put("name", Student::getName);
        params.put("gender", Student::getGender);
        params.put("student_number", Student::getStringStudentNumber);

        return params;
    }

    private String getUpdateRequest(Student student, int id) {
        StringBuilder sql = new StringBuilder()
                .append("Update student set ");

        Map<String, Function<Student, String>> params = getParams();
        String updateParams = params.entrySet().stream()
                .filter(entry -> !entry.getValue().apply(student).equals("-1"))
                .map(entry -> entry.getKey() + "=" + helper(entry.getValue().apply(student)))
                .collect(Collectors.joining(","));
        sql.append(updateParams);

        return sql.append(" where id = " + id + ";").toString();
    }

    private String helper(String mapValue) {
        boolean isDigit;
        try {
            Integer.parseInt(mapValue);
            isDigit = true;
        } catch (NumberFormatException e) {
            isDigit = false;
        }

        if (isDigit) {
            return mapValue;
        }
        return String.format("'%s'", mapValue);
    }

    public String getHtml() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("<table>\n" +
                        "<tr><th>Id</th>" +
                        "<th>Name</th>" +
                        "<th>Gender</th>" +
                        "<th>Student Number</th></tr>");

        students.forEach(student -> {
            stringBuilder.append("<tr><td>" + student.getId() + "</td>")
                    .append("<td>" + student.getName() + "</td>")
                    .append("<td>" + student.getGender() + "</td>")
                    .append("<td>" + student.getStudentNumber() + "</td></tr>");
        });

        return stringBuilder.append("</table>").toString();
    }
}
