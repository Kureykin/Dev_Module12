package utils;

import org.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTicketUtil {
    private static final HibernateTicketUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateTicketUtil();
    }

    public static HibernateTicketUtil getInstance() {
        return INSTANCE;
    }

    private HibernateTicketUtil() {
        sessionFactory = new Configuration().addAnnotatedClass(Ticket.class)
                .addAnnotatedClass(Client.class).addAnnotatedClass(Planet.class)
                .buildSessionFactory();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
