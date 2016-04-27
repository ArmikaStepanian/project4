package ru.stepanian.project4.service;

import ru.stepanian.project4.product.entities.*;
import ru.stepanian.project4.user.model.UserDto;
import ru.stepanian.project4.user.entities.User;
import ru.stepanian.project4.user.exceptions.LoginExistsException;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

public interface ProjectService {

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

    public User createNewUserAccount(UserDto userDto)throws LoginExistsException;
    public void saveCreatedNewUserAccount(User user);
    public User getUserByLogin (String login);
    public void saveGroupMember(UserDto userDto);
}
