package org.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Planet")
@Getter
@Setter
public class Planet {
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "name")
    String name;

    public Planet(){

    }

    @Override
    public String toString() {
        return "ID: " + id + "; Name: " + name;
    }

}
