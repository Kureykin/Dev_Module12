package org.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "Client")
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 200)
    private String name;

    @OneToMany(mappedBy = "clientId")
    private Set<Ticket> ticket;

    public Client() {

    }

    @Override
    public String toString() {
        return "ID: "+ id +"; Name: " + name;
    }
}
