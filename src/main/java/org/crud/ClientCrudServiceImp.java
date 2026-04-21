package org.crud;

import org.dao.servic.ClientDaoService;
import org.dao.servic.ClientDaoServiceImp;
import org.entity.Client;

public class ClientCrudServiceImp implements ClientCrudService {

    private ClientDaoService clientDaoService;

    public ClientCrudServiceImp(ClientDaoService clientDaoService) {
        this.clientDaoService = clientDaoService;
    }

    @Override
    public void add(Client client){
        clientDaoService.add(client);
    }

    @Override
    public Client read(long id){
        return clientDaoService.read(id);
    }
}
