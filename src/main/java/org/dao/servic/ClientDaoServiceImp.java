package org.dao.servic;

import org.entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DatabaseConnection;
import utils.HibernateClientUtil;


public class ClientDaoServiceImp implements ClientDaoService{

    @Override
    public Client read(long id) {

        try(Session session = HibernateClientUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Client client) {

        Transaction transaction = null;
        try (Session session = HibernateClientUtil.getInstance().getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            session.persist(client);
            transaction.commit();
        } catch (Exception e) {

            if(transaction != null && transaction.getRollbackOnly()) {
                transaction.rollback();
            }

            throw new RuntimeException(e.getMessage());
        }
    }


}
