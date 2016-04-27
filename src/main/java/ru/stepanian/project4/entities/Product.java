package ru.stepanian.project4.entities;

import javax.persistence.*;

/**
 * Created by Stepanian on 08.04.2016.
 */

@Entity
@Table
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="color",referencedColumnName="id")
    private Colors color;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="feature",referencedColumnName="id")
    private Feature feature;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="category",referencedColumnName="id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Product) && (id != null)
                ? id.equals(((Product) other).id)
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
        return String.format("Product [%d, %s]", id, name);
    }


}
