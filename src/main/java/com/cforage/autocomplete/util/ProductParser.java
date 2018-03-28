package com.cforage.autocomplete.util;


import com.cforage.autocomplete.model.Product;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductParser {

    private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).setPrettyPrinting().create();

    // returning List<> in order to code to interface
    public List<Product> parse (String path){

        try(FileReader reader = new FileReader(path)){

            Product[] products = gson.fromJson(reader, Product[].class);
            return new ArrayList(Arrays.asList(products));
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
