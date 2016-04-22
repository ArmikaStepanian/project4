package ru.stepanian.project4.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.stepanian.project4.entities.Category;
import ru.stepanian.project4.entities.Colors;
import ru.stepanian.project4.entities.Feature;
import ru.stepanian.project4.entities.Product;

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
    public List<Colors> listColors(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "from Colors c order by c.name");
        return (List<Colors>)query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> listCategories(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "from Category cat order by cat.name");
        return (List<Category>)query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Feature> listFeatures(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "from Feature");
        return (List<Feature>)query.list();
    }

    @Override
    public long getCountAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select count (*) from Product p");
        return (Long)query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProdWithPagination(int resultsPerPage,int page) {
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select p.id as id, p.name as name, p.color as color, p.feature as feature, p.category as category from Product p order by p.id");
        query.setMaxResults(resultsPerPage);
        if (page <= 0)
            query.setFirstResult(page * resultsPerPage);
        else
            query.setFirstResult((page - 1) * resultsPerPage);
        return query.setResultTransformer(Transformers.aliasToBean(Product.class)).list();
    }

    @Override
    public long getCountByParameters(String name, String color, String category, String feature){
        if(color.equals(""))
            color = "%";
        if(category.equals(""))
            category = "%";
        if(feature.equals(""))
            feature = "%";
        Query query = sessionFactory.getCurrentSession().createQuery("" +
                "select count (*) from Product p where p.name like :name and p.color.name like :color and p.feature.name like :feature and p.category.name like :category");
        query.setParameter("name", (name +"%"));
        query.setParameter("color", color);
        query.setParameter("category", category);
        query.setParameter("feature", feature);
        return  (Long)query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getProdByParamWithPagination(String name, String color, String category, String feature,
                                                      int resultsPerPage,int page) {

        if(color.equals(""))
            color = "%";
        if(category.equals(""))
            category = "%";
        if(feature.equals(""))
            feature = "%";

        String str = "select p.id as id, p.name as name, p.color as color, p.feature as feature, p.category as category from Product p " +
                "where p.name like :name and p.color.name like :color and p.feature.name like :feature and p.category.name like :category order by p.id";

        Query query = sessionFactory.getCurrentSession().createQuery(str).setResultTransformer(Transformers.aliasToBean(Product.class));
        query.setParameter("name", (name +"%"));
        query.setParameter("color", color);
        query.setParameter("category", category);
        query.setParameter("feature", feature);
        query.setMaxResults(resultsPerPage);
        if (page <= 0)
            query.setFirstResult(page * resultsPerPage);
        else
            query.setFirstResult((page - 1) * resultsPerPage);
        return query.setResultTransformer(Transformers.aliasToBean(Product.class)).list();
    }

    @Override
    public Product getProductById(Long id){
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public void addProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }
    @Override
    public void updateProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

}
