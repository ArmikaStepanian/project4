package ru.stepanian.project4.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.stepanian.project4.entities.Product;
import ru.stepanian.project4.model.ProductModel;

import java.util.List;

/**
 * Created by Stepanian on 08.04.2016.
 */

@Repository
public class DAOImpl implements DAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* as - обязательно, это ключи для карты */
    /* p.color - означает вытащить и color.id и color.name */
    /* aliasToBean - привести к виду бина */
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> listProduct(int selectedPageNumber){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select p.id as id, p.name as name, p.color as color, p.feature as feature from Product p order by p.id")
                .setResultTransformer(Transformers.aliasToBean(Product.class)); /* привести к виду бина */
        return (List<Product>)query.list();
    }

    @Override
    public long getCount(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select count (*) from Product p");
        Long count = (Long)query.uniqueResult();
        return count;
    }



    @SuppressWarnings("unchecked")
    @Override
    public List<String> getListColors(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select c.name as name from Colors c order by c.name");
        return (List<String>)query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> listCategories(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select cat.name as name from Category cat order by cat.name");
        return (List<String>)query.list();
    }
    @Override
    public List pagination(int resultsPerPage,int page) {
        String str = String.format("select p.id as id, p.name as name, p.color as color, p.feature as feature from Product p");
        Query query = sessionFactory.getCurrentSession().createQuery(str);
        query.setMaxResults(resultsPerPage);
        if (page <= 0)
            query.setFirstResult(page * resultsPerPage);
        else
            query.setFirstResult((page - 1) * resultsPerPage);
        List list = query.setResultTransformer(Transformers.aliasToBean(Product.class)).list();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProductByParameters(ProductModel productModel) {

        if(productModel.getColor().equals(""))
            productModel.setColor("%");
        if(productModel.getFeature().equals(""))
           productModel.setFeature("%");
        if(productModel.getCategory().equals(""))
           productModel.setCategory("%");

        String str = "select p.id as id, p.name as name, p.color as color, p.feature as feature, p.category as category from Product p " +
                "where p.name like :name and p.color.name like :color and p.feature.name like :feature and p.category.name like :category order by p.id";

        Query query = sessionFactory.getCurrentSession().createQuery(str).setResultTransformer(Transformers.aliasToBean(Product.class));
        query.setParameter("name", (productModel.getName()+"%"));
        query.setParameter("color", productModel.getColor());
        query.setParameter("feature", productModel.getFeature());
        query.setParameter("category", productModel.getCategory());
        return (List<Product>) query.list();

    }

    @SuppressWarnings("unchecked")
    @Override
    public Product getById(Long id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Product.class, id);

    }





}
