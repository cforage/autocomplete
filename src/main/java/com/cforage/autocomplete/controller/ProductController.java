package com.cforage.autocomplete.controller;


import com.cforage.autocomplete.data.ProductRepository;
import com.cforage.autocomplete.model.Product;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //breaking coding for the interface for prototype development ease.
    private LoadingCache<String, Product> cache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<String, Product>() {

        @Override
        public Product load(String key) throws Exception {

            return productRepository.findById(key).get();

        }

    });


    @PostConstruct
    public void init(){
        List<Product> productList = find("another");
        productList.forEach(product -> System.out.println(product));
    }

    public List<Product> find(String input){

        return productRepository.findProductsByName(input);
    }



}
