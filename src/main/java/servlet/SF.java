package servlet;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import entities.Driver;
import entities.UserSession;

public class SF {
    private static SessionFactory sf;
    private static void init(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception x){
            System.err.println("Couldn't find MSSQL!");
        }

        Configuration cfg = new Configuration()
                .addAnnotatedClass(Driver.class)
                .addAnnotatedClass(UserSession.class);

        cfg.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost\\FFLLOCAL;database=Drivers;CharacterSet=UTF-8");
        cfg.setProperty("hibernate.connection.username", "feyfolken");
        cfg.setProperty("hibernate.connection.password", "admin");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());
        sf = cfg.buildSessionFactory(builder.build());
    }

    static {
        init();
    }

    private SF(){}

    public static SessionFactory getInstance(){
        if(sf == null) {
            init();
        }
        return sf;
    }
}