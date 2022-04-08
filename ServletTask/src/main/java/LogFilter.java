import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

@WebFilter("/table")
public class LogFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(LogFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String action = request.getParameter("action");

        String message = (action.equals("get")) ? "Entries" : "Entry";
        LOGGER.log(Level.INFO, String.format("%s %s", message, action));

        chain.doFilter(request, response);
    }
}
