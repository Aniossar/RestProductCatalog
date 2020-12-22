package com.product_catalog.dao;

import com.product_catalog.Entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImplementation implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public void removeProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        session.delete(product);
    }

    @Override
    public Product getProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product", Product.class).getResultList();
        return productList;
    }

    @Override
    public List<Product> getProductViaName(String productName) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "from Product where productName = :paramName";
        Query query = session.createQuery(sql);
        query.setParameter("paramName", productName);
        return query.list();
    }
}
