package org.dao.servic;

import org.entity.Planet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DatabaseConnection;
import utils.HibernatePlanetUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanetDaoServiceImp implements PlanetDaoService{

    @Override
    public Planet read(String id) {

        Planet planet = null;
        try(Session session = HibernatePlanetUtil.getInstance().getSessionFactory().openSession()) {
            planet = session.get(Planet.class, id);

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

        return planet;
    }

    @Override
    public void add(Planet planet) {

        Transaction transaction = null;

        try(Session session = HibernatePlanetUtil.getInstance().getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }


}
