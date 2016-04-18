package ru.stepanian.project4.dao;

import ru.stepanian.project4.entities.Product;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface DAO {


    public List<String> listColors();
    public List<String> listCategories();
    public Product getProductById(Long id);


    public long getCountAll();
    public List<Product> getAllProdWithPagination(int resultsPerPage,int page);
    public long getCountByParameters(String name,String color,String category,String feature);
    public List<Product> getProdByParamWithPagination(String name,String color,String category,String feature,int resultsPerPage,int page);


}
