package ru.stepanian.project4.service;

import ru.stepanian.project4.entities.Product;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface ProductService {

    public List<Product> listProduct(int selectedPageNumber);
    public List<String> getListColors();
    public List<String> listCategories();
    public List<Product> getProductByParameters(String name,String color,String category,String feature,int resultsPerPage,int page);
    public Product getById(Long id);

    public long getCount();
    public List pagination(int resultsPerPage,int page);
    public long getCount2(String name,String color,String category,String feature);
}
