import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
            case "add":

                break;
            case "delete":

                break;
            case "update":

                break;
        }

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        if (studentRead != "") {
            printWriter.write(studentRead);
        } else {
            printWriter.write("You have som problems, action: " + action);
        }

        printWriter.close();

    }
}
