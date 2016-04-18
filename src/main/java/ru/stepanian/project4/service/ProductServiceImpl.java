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
    public List<String> listColors() { return dao.listColors(); }

    @Transactional
    @Override
    public List<String> listCategories() { return dao.listCategories(); }

    @Transactional
    @Override
    public List<Product> getProdByParamWithPagination(String name,String color,String category,String feature,int resultsPerPage,int page)
    { return dao.getProdByParamWithPagination(name, color, category,feature, resultsPerPage, page); }

    @Transactional
    @Override
    public Product getProductById(Long id) { return dao.getProductById(id); }

    @Transactional
    @Override
    public long getCountAll(){return dao.getCountAll();}

    @Transactional
    @Override
    public List<Product> getAllProdWithPagination(int resultsPerPage,int page){return dao.getAllProdWithPagination(resultsPerPage, page);}

    @Transactional
    @Override
    public long getCountByParameters(String name, String color, String category, String feature)
    {return dao.getCountByParameters(name, color, category, feature);}


}
