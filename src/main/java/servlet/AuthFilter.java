package servlet;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String login_ss = (String)req.getSession().getAttribute("login");
        if (login_ss == null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (login == null) {
                req.getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
            } else {
                Session session = SF.getInstance().openSession();
                HttpSession session_log = req.getSession();
                List log_pas = session.createQuery("from UserSession where login = :login and password = :password")
                        .setParameter("login", login).setParameter("password", password).list();
                if (log_pas.size() > 0) {
                    session_log.setAttribute("login",login);
                    resp.sendRedirect(req.getContextPath());
                } else {
                    req.getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}