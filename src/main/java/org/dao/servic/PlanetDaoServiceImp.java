package org.dao.servic;

import org.entity.Planet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernatePlanetUtil;

public class PlanetDaoServiceImp implements PlanetDaoService{

    @Override
    public Planet read(String id) {

        Planet planet = null;
        try {
            Session session = HibernatePlanetUtil.getInstance().getSessionFactory().openSession();

            planet = session.get(Planet.class, id);

            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        return planet;
    }

    @Override
    public void add(Planet planet) {

        if(planet.getClass() != Planet.class){
            throw new RuntimeException("False entity type");
        }

        try(Session session = HibernatePlanetUtil.getInstance().getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
