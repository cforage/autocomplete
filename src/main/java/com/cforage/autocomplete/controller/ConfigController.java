package com.cforage.autocomplete.controller;

import com.cforage.autocomplete.model.Config;
import com.cforage.autocomplete.model.Product;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ConfigController {

    private Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES).setPrettyPrinting().create();

    @Getter
    private Config config;


    public Config parse(String path) {

        try (FileReader reader = new FileReader(path)) {

            Config config = gson.fromJson(reader, Config.class);
            return config;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    public void init(){
        System.out.println("PARSE");
        this.config = parse("lib/config.json");
        System.out.println(config);
    }
}
