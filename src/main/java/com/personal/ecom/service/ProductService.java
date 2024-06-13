package com.personal.ecom.service;

import com.personal.ecom.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public void createProduct(Product product);

    public Optional<Product> getProductById(Integer id);

    public List<Product> getAllProducts();

    public Optional<Product> deleteProductById(Integer id);

    public Optional<Product> updateProductById(Integer id, Product product);
}
