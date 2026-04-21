package org.dao.servic;

import org.entity.Client;

public interface ClientDaoService {

    public void add(Client client);
    public Client read(long id);
}
