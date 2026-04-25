package org.dao.servic;

import org.entity.Ticket;

public interface TicketDaoService {
    public Ticket read(long id);
    public void add(Ticket ticket);
}
