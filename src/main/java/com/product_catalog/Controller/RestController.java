package com.product_catalog.Controller;

import com.product_catalog.Entity.Product;
import com.product_catalog.Exception.NoSuchProductException;
import com.product_catalog.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        if (productService.getProduct(id) == null) {
            throw new NoSuchProductException("There is no such product");
        }
        return productService.getProduct(id);
    }

    @GetMapping("/products/search/{productName}")
    public List<Product> getProductViaName(@PathVariable String productName) {
        if (productService.getProductViaName(productName).isEmpty()) {
            throw new NoSuchProductException("There is no such product");
        }
        return productService.getProductViaName(productName);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping("/products")
    public void addNewProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/products")
    public void editProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void removeProduct(@PathVariable int id) {
        if (productService.getProduct(id) == null) {
            throw new NoSuchProductException("There is no product with such ID");
        }
        productService.removeProduct(id);
    }

}
