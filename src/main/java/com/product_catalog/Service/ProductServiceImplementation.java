package com.product_catalog.Service;

import com.product_catalog.Entity.Product;
import com.product_catalog.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    @Transactional
    @Override
    public void removeProduct(int id) {
        productDAO.removeProduct(id);
    }

    @Transactional
    @Override
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Transactional
    @Override
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }

    @Transactional
    @Override
    public List<Product> getProductViaName(String productName) {
        return productDAO.getProductViaName(productName);
    }
}
