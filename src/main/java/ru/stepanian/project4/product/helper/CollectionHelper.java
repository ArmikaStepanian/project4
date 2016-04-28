package ru.stepanian.project4.product.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stepanian.project4.entities.Category;
import ru.stepanian.project4.entities.Colors;
import ru.stepanian.project4.entities.Feature;
import ru.stepanian.project4.service.ProjectService;

import java.util.List;

/**
 * Created by Stepanian on 28.04.2016.
 */

@Component
public class CollectionHelper {

    @Autowired
    private ProjectService projectService;

    private List<Colors> colors = projectService.listColors();
    private List<Category> categories = projectService.listCategories();
    private List<Feature> features = projectService.listFeatures();

    public List<Colors> getColors() {
        return colors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
