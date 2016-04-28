package ru.stepanian.project4.product.helper;

import org.springframework.beans.factory.annotation.Autowired;
import ru.stepanian.project4.entities.Category;
import ru.stepanian.project4.entities.Colors;
import ru.stepanian.project4.entities.Feature;
import ru.stepanian.project4.service.ProjectService;

import java.util.List;

/**
 * Created by Stepanian on 28.04.2016.
 */

public class CollectionHelper {

    @Autowired
    private ProjectService projectService;

    public List<Colors> colors;
    public List<Category> categories;
    public List<Feature> features;

    public List<Colors> getColors(){
        if (colors==null)
            return projectService.listColors();
        return colors;
    }
    public List<Category> getCategories(){
        if (categories==null)
            return projectService.listCategories();
        return categories;
    }
    public List<Feature> getFeatures(){
        if (features==null)
            return projectService.listFeatures();
        return features;
    }
}
