package com.cforage.autocomplete.data;


import com.cforage.autocomplete.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository extends JpaRepository<Product,String> {

    @Override
    Optional<Product> findById(String s);


    //Generating Spring-query for finding partial matches.
    @Query("select p from Product p where p.name like :productName%")
    List<Product> findProductsByName(@Param("productName") String productName);



//    @Override
//    <S extends T> List<S> findAll(Example<S> example);
}
