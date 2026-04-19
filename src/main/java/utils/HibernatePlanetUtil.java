package utils;

import lombok.Getter;
import org.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePlanetUtil {
    private static final HibernatePlanetUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernatePlanetUtil();
    }

    public static HibernatePlanetUtil getInstance() {
        return INSTANCE;
    }

    private HibernatePlanetUtil() {
        sessionFactory = new Configuration().addAnnotatedClass(Planet.class).buildSessionFactory();
        boolean hasPersister = sessionFactory.getMetamodel().entity(Planet.class) != null;
        System.out.println("Is entity registered? " + hasPersister);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
