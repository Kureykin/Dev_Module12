package org;

import org.crud.ClientCrudServiceImp;
import org.crud.PlanetCrudServiceImp;
import org.dao.servic.ClientDaoServiceImp;
import org.dao.servic.PlanetDaoServiceImp;
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

        ClientCrudServiceImp clientCrudService = new ClientCrudServiceImp(new ClientDaoServiceImp());

        clientCrudService.add(client);

        PlanetCrudServiceImp planetCrudService = new PlanetCrudServiceImp(new PlanetDaoServiceImp());

        planetCrudService.add(planet);

        System.out.println(clientCrudService.read(1L));
       System.out.println(planetCrudService.read("NOVA77"));
    }
}
