package org.dao.servic;

import org.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateClientUtil;

public class ClientDaoServiceImp implements ClientDaoService{

    @Override
    public Client read(long id) {
        Session session = HibernateClientUtil.getInstance().getSessionFactory().openSession();

        Client client = session.get(Client.class, id);

        session.close();

        return client;
    }

    @Override
    public void add(Client client) {

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
