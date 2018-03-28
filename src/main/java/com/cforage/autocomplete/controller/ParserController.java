package com.cforage.autocomplete.controller;

import com.cforage.autocomplete.data.ProductRepository;
import com.cforage.autocomplete.util.ProductParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
public class ParserController {


    @Autowired
    private ProductParser productParser;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConfigController configController;

    private ExecutorService executor = Executors.newFixedThreadPool(16);

    @PostConstruct
    public void Parse(){

        if(configController.getConfig().isParseData())
        {


            CompletableFuture.supplyAsync(()->productParser.parse("lib/sm-products.json")).thenAcceptAsync(products->
            {
                products.forEach(line->{
                    System.out.println(line);
                    productRepository.save(line);
                });
            }, executor);

//            productParser.parse("lib/sm-products.json").forEach(line->{
//
//                System.out.println(line); //Print statement for output purposes
//                productRepository.save(line);
//
//            });
        }

    }
}
