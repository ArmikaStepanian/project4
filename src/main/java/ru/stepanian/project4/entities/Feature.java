package ru.stepanian.project4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Stepanian on 12.04.2016.
 */

@Entity
@Table
public class Feature {

    @Id
    @Column
    private Byte id;

    @Column
    private String name;

    public Feature() {
    }

    public Feature(Byte id) {
        this.id = id;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
