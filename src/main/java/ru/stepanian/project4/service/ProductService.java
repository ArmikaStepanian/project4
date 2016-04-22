package ru.stepanian.project4.service;

import ru.stepanian.project4.entities.Category;
import ru.stepanian.project4.entities.Colors;
import ru.stepanian.project4.entities.Feature;
import ru.stepanian.project4.entities.Product;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface ProductService {


    public List<Colors> listColors();
    public List<Category> listCategories();
    public List<Feature> listFeatures();
    public Product getProductById(Long id);

    public long getCountAll();
    public List<Product> getAllProdWithPagination(int resultsPerPage,int page);
    public long getCountByParameters(String name,String color,String category,String feature);
    public List<Product> getProdByParamWithPagination(String name,String color,String category,String feature,int resultsPerPage,int page);

    public void addProduct (Product product);
    public void updateProduct (Product product);
}
