package org;

import org.crud.ClientCrudServiceImp;
import org.crud.PlanetCrudServiceImp;
import org.dao.servic.ClientDaoServiceImp;
import org.dao.servic.PlanetDaoServiceImp;
import org.dao.servic.TicketDaoService;
import org.dao.servic.TicketDaoServiceImp;
import org.entity.Client;
import org.entity.Planet;
import org.entity.Ticket;
import org.flywaydb.core.Flyway;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Locale;

public class Main {
    static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:file:./resources/db/test.db", "SA", null)
                .locations("filesystem:src/main/resources/SQLScripts")
                .load();

        flyway.migrate();

        Client client = new Client();
        Planet planet = new Planet();
        Ticket ticket = new Ticket();

        TicketDaoService ticketDaoService = new TicketDaoServiceImp();

        System.out.println(ticketDaoService.read(2));

        client.setId(100);
        client.setName("aaasdw");

        ClientCrudServiceImp clientCrudService = new ClientCrudServiceImp(new ClientDaoServiceImp());
        PlanetCrudServiceImp planetCrudService = new PlanetCrudServiceImp(new PlanetDaoServiceImp());



        ticket.setCreatedAt(Timestamp.valueOf("2020-01-01 00:00:00"));
        ticket.setClientId(client);
        ticket.setFromPlanetId(planetCrudService.read("XEN900"));
        ticket.setToPlanetId(planetCrudService.read("XEN900"));



        ticketDaoService.add(ticket);

    }
}
