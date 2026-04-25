package org.dao.servic;


import org.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateTicketUtil;

public class TicketDaoServiceImp implements TicketDaoService {
    @Override
    public Ticket read(long id) {

        try(Session session = HibernateTicketUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void add(Ticket ticket) {
        if (!ticket.canExist()) {
            throw new RuntimeException("Incorrect ID`s");
        }

        Transaction transaction = null;

        try(Session session = HibernateTicketUtil.getInstance().getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}
