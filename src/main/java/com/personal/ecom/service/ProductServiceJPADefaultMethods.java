package com.personal.ecom.service;

import com.personal.ecom.model.Product;
import com.personal.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJPADefaultMethods implements ProductService{

    ProductRepository productRepository;

    //@ could be resolved using the AuotWired as well
    public ProductServiceJPADefaultMethods(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> deleteProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            productRepository.deleteById(id);
        }
        return product;
    }

    @Override
    public Optional<Product> updateProductById(Integer id, Product product) {
        Optional<Product> productFound = getProductById(id);
        if(productFound.isPresent()) {
            productFound.get().setTitle(product.getTitle());
            productFound.get().setPrice(product.getPrice());
            productFound.get().setDescription(product.getDescription());
            productFound.get().setCategory(product.getCategory());
            productFound.get().setImageUrl(product.getImageUrl());
            productRepository.save(productFound.get());
        }
        return productFound;
    }
}
