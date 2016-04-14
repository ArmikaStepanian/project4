package ru.stepanian.project4.model;

import java.io.Serializable;

/**
 * Created by 1 on 12.04.2016.
 */

public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String color;
    private String feature = "";
    private String category;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
