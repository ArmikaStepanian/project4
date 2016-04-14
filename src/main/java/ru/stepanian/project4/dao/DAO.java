package ru.stepanian.project4.dao;

import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface DAO {

    public List<Product> listProduct();

    public List<String> listColors();
    public List<Product> getProductByParameters(ProductModel productModel);
    public Product getById(Long id);


}
