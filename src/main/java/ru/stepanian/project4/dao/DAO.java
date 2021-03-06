package ru.stepanian.project4.dao;

import ru.stepanian.project4.entities.*;
import ru.stepanian.project4.user.model.UserDto;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface DAO {

    public List<Colors> listColors();
    public List<Category> listCategories();
    public List<Feature> listFeatures();

    public Product getProductById(Long id);
    public long getCountAll();
    public List<Product> getAllProdWithPagination(int resultsPerPage,int page);
    public long getCountByParameters(String name, String color, String category, String feature);
    public List<Product> getProdByParamWithPagination(String name, String color, String category, String feature, int resultsPerPage, int page);
    public void addProduct (Product product);
    public void updateProduct (Product product);
    public void deleteProduct (Product product);

    public User createNewUserAccount(UserDto userDto);
    public void saveCreatedNewUserAccount(User user);
    public User getUserByLogin (String login);
    public void saveGroupMember(UserDto userDto);
}
