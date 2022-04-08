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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        StudentSqlRequest student = new StudentSqlRequest();
        String studentRead = "";

        switch (action) {
            case "get":
                studentRead = student.read();
                break;
            case "delete":
                String id = req.getParameter("id");
                student.delete(parseInt(id));
                studentRead = student.read();
        }

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (studentRead != "") {
            printWriter.write(studentRead);
        } else {
            printWriter.write("You have some problems, action: " + action);
        }

        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try (BufferedReader reader = req.getReader()) {
            while ((line = reader.readLine()) != null)
                stringBuffer.append(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(stringBuffer.toString(), Student.class);

        StudentSqlRequest studentSqlRequest = new StudentSqlRequest();

        switch (action) {
            case "add":
                studentSqlRequest.add(student);
                break;
            case "update":
                String id = req.getParameter("id");
                studentSqlRequest.update(student, Integer.parseInt(id));
        }

        String studentSqlRead = studentSqlRequest.read();
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (studentSqlRead != "") {
            printWriter.write(studentSqlRead);
        } else {
            printWriter.write("You have some problems, action: " + action);
        }

        printWriter.close();
    }
}
