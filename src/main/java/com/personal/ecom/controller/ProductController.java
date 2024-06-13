package com.personal.ecom.controller;

import com.personal.ecom.model.Product;
import com.personal.ecom.service.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<Product>(product, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(Integer.parseInt(id));

        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        return  new ResponseEntity<Product>(product.get(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if(products == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> productFromDb = productService.updateProductById(Integer.parseInt(id), product);
        if(productFromDb == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Product>(productFromDb.get(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable String id) {
        Optional<Product> product = productService.deleteProductById(Integer.parseInt(id));
        if(product == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }
}
