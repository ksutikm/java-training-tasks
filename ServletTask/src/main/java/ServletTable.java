import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Integer.parseInt;

@WebServlet("/table")
public class ServletTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        StudentSqlRequest student = new StudentSqlRequest();
        String studentRead = "";

        switch (action) {
            case "get":
                studentRead = student.read();
                break;
            case "delete":
                String id = request.getParameter("id");
                student.delete(parseInt(id));
                studentRead = student.read();
        }

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        if (studentRead != "") {
            printWriter.write(studentRead);
        } else {
            printWriter.write("You have some problems, action: " + action);
        }

        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(request.getReader(), Student.class);

        StudentSqlRequest studentSqlRequest = new StudentSqlRequest();

        switch (action) {
            case "add":
                studentSqlRequest.add(student);
                break;
            case "update":
                String id = request.getParameter("id");
                studentSqlRequest.update(student, Integer.parseInt(id));
        }

        String studentSqlRead = studentSqlRequest.read();
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        if (studentSqlRead != "") {
            printWriter.write(studentSqlRead);
        } else {
            printWriter.write("You have some problems, action: " + action);
        }

        printWriter.close();
    }
}
