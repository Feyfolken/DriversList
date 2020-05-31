package servlet;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entities.Driver;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneralServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String act = req.getParameter("rm");
        if (act != null) {
            int Id = Integer.parseInt(act);
            delete(Id);
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        Session session = SF.getInstance().openSession();

        List q = session.createQuery("from Driver").list();
        List<Driver> drivers = new ArrayList<Driver>();

        if(q.size() > 0) {
            for(Object driver: q) {
                Driver dr = (Driver) driver;
                drivers.add(dr);
            }
        }
        session.close();
        req.setAttribute("drivers", drivers);
        req.getRequestDispatcher("/pages/drivers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Driver driver = new Driver();
        driver.setId(Integer.parseInt(req.getParameter("id")));
        driver.setSurname(req.getParameter("surname"));
        driver.setName(req.getParameter("name"));
        driver.setPatronymic(req.getParameter("patronymic"));
        driver.setLicense_cathegory(req.getParameter("license_cathegory"));
        driver.setAge(req.getParameter("age"));
        driver.setExperience(req.getParameter("experience"));

        query(driver, driver.getId() > 0 ? "update" : "save");
        resp.sendRedirect(req.getContextPath() + "/");
    }

    private static void query(Object el, String act) {
        try {
            Session ss = SF.getInstance().openSession();
            try {
                Transaction tr = ss.beginTransaction();
                if (act.equals("save"))
                    ss.save(el);
                else if (act.equals("update"))
                    ss.saveOrUpdate(el);
                else if (act.equals("delete"))
                    ss.delete(el);
                ss.flush();
                tr.commit();
            } catch (HibernateException exp) { }
            finally {
                ss.close();
            }
        } catch (ExceptionInInitializerError exc) {}
    }

    public static void delete(int id) {
        try {
            Session ss = SF.getInstance().openSession();
            Transaction tr = ss.beginTransaction();
            Driver driver = ss.byId(Driver.class).load(id);
            ss.delete(driver);
            ss.flush();
            tr.commit();
            ss.close();
        }
        catch (ExceptionInInitializerError exc){}
    }
}
