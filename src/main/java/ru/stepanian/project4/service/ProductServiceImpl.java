package ru.stepanian.project4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stepanian.project4.dao.DAO;
import ru.stepanian.project4.entities.Product;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public List<Product> listProduct(int selectedPageNumber) { return dao.listProduct(selectedPageNumber); }

    @Transactional
    @Override
    public List<String> getListColors() { return dao.getListColors(); }

    @Transactional
    @Override
    public List<String> listCategories() { return dao.listCategories(); }

    @Transactional
    @Override
    public List<Product> getProductByParameters(String name,String color,String category,String feature,int resultsPerPage,int page)
    { return dao.getProductByParameters(name,color,category,feature, resultsPerPage, page); }

    @Transactional
    @Override
    public Product getById(Long id) { return dao.getById(id); }
    @Transactional
    @Override
    public long getCount(){return dao.getCount();}
    @Transactional
    @Override
    public List pagination(int resultsPerPage,int page){return dao.pagination(resultsPerPage,page);}
    @Transactional
    @Override
    public long getCount2(String name,String color,String category,String feature)
    {return dao.getCount2(name,color,category,feature);}


}
