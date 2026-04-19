package org.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateClientUtil;
import org.entity.Client;

public class ClientCrudService {

    public Client readEntity(long id) {
        Session session = HibernateClientUtil.getInstance().getSessionFactory().openSession();

        Client client = session.get(Client.class, id);

        session.close();

        return client;
    }

    public void addEntity(Client client) {

        Transaction transaction = null;
        try (Session session = HibernateClientUtil.getInstance().getSessionFactory().openSession()){

            transaction = session.beginTransaction();
            System.out.println("transaction: " + transaction.getClass().getName());
            System.out.println("Status: " + transaction.getStatus());

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
