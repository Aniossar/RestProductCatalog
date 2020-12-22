package com.product_catalog.Service;

import com.product_catalog.Entity.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);

    public void removeProduct(int id);

    public Product getProduct(int id);

    public List<Product> getAllProduct();

    public List<Product> getProductViaName(String productName);
}
