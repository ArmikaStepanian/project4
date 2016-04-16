package ru.stepanian.project4.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Stepanian on 08.04.2016.
 */

@Entity
@Table
public class Colors implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
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
        return (other instanceof Colors) && (id != null)
                ? id.equals(((Colors) other).id)
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
