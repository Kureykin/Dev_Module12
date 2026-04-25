package org.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Entity
@Table(name = "Planet")
@Getter
@Setter
public class Planet {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fromPlanetId")
    private Set<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanetId")
    private Set<Ticket> ticketsTo;

    public Planet(){

    }

    @Override
    public String toString() {
        return "ID: " + id + "; Name: " + name;
    }

}
