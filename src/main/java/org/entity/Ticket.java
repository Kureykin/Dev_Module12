package org.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.dao.servic.ClientDaoServiceImp;
import org.dao.servic.PlanetDaoServiceImp;
import utils.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;

@Entity
@Table(name = "Ticket")
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "FROM_PLANET_ID", nullable = false)
    private Planet fromPlanetId;

    @ManyToOne
    @JoinColumn(name = "TO_PLANET_ID", nullable = false)
    private Planet toPlanetId;

    public Ticket() {

    }

    private boolean isPlanetExist(Planet planet) {

        return new PlanetDaoServiceImp().read(planet.getId()) != null;
    }

    private boolean isClientExist(Client client) {
        return new ClientDaoServiceImp().read(client.getId()) != null;
    }

    public boolean canExist() {
            return isPlanetExist(fromPlanetId) && isPlanetExist(toPlanetId) && isClientExist(clientId);
    }

    @Override
    public String toString(){
        return "Ticket ID: " + id + "; Created at " + createdAt.toString() + " from  " + fromPlanetId + " to " + toPlanetId;
    }
}
