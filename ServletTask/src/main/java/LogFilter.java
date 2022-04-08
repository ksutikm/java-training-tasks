import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

@WebFilter("/table")
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("LogFilter init!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String action = request.getParameter("action");
        Logger logger = Logger.getLogger(LogFilter.class.getName());

        String message = (action.equals("get")) ? "Entries" : "Entry";
        logger.log(Level.INFO, String.format("%s %s", message, action));

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("LogFilter destroy!");
    }
}
