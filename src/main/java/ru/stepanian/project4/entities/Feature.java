package ru.stepanian.project4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 1 on 12.04.2016.
 */

@Entity
@Table
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private Byte id;

    @Column
    private String name;

    public Byte getId() {
        return id;
    }

   /* public void setId(Byte id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Feature) && (id != null)
                ? id.equals(((Feature) other).id)
                : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
                ? (this.getClass().hashCode() + id.hashCode())
                : super.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

}
