package ru.stepanian.project4.dao;

import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface DAO {

    public List<Product> listProduct(int selectedPageNumber);
    public List<String> getListColors();
    public List<String> listCategories();
    public List<Product> getProductByParameters(ProductModel productModel,int resultsPerPage,int page);
    public Product getById(Long id);


    public long getCount();
    public List pagination(int resultsPerPage,int page);
    public long getCount2(ProductModel productModel);


}
