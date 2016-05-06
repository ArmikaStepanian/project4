package ru.stepanian.project4.product.model;

import org.springframework.stereotype.Component;

/**
 * Created by Stepanian on 20.04.2016.
 */

@Component
public class ProductModel {

    private Long id;
    private String name;
    private String color;
    private String category;
    private String feature = "";

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
