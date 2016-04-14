package ru.stepanian.project4.service;

import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface ProductService {

    public List<Product> listProduct();

    public List<String> listColors();
    public List<String> listCategories();
    public List<Product> getProductByParameters(ProductModel productModel);
    public Product getById(Long id);

}
