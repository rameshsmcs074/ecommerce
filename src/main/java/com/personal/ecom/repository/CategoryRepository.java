package com.personal.ecom.repository;

import com.personal.ecom.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    //@by default all the JPA default methods are available
}
