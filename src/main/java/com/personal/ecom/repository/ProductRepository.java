package com.personal.ecom.repository;

import com.personal.ecom.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    //@all the JPA default methods are available
    //@ findbyId, findByName...
}
