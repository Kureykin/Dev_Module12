package utils;

import org.entity.Planet;
import org.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.entity.Client;

public class HibernateClientUtil {

    private static final HibernateClientUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateClientUtil();
    }

    HibernateClientUtil() {
        sessionFactory = new Configuration().addAnnotatedClass(Client.class)
                .addAnnotatedClass(Ticket.class).addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static  HibernateClientUtil getInstance() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}
