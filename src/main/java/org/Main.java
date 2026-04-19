package org;

import org.crud.ClientCrudService;
import org.crud.PlanetCrudService;
import org.entity.Client;
import org.entity.Planet;
import org.flywaydb.core.Flyway;

public class Main {
    static void main(String[] args) {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:file:./test.db", "SA", null)
                .locations("filesystem:src/main/resources/SQLScripts")
                .load();

        flyway.migrate();

        Client client = new Client();
        Planet planet = new Planet();

        client.setName("Artur");

        planet.setId("MARC1");
        planet.setName("Marc");

        ClientCrudService clientCrudService = new ClientCrudService();

        clientCrudService.addEntity(client);

        PlanetCrudService planetCrudService = new PlanetCrudService();

        //planetCrudService.addEntity(planet);

//        System.out.println(clientCrudService.readEntity(1L));
       System.out.println(planetCrudService.readEntity("NOVA77"));
    }
}
