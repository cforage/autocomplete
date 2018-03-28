package com.cforage.autocomplete.mediator;

import com.cforage.autocomplete.controller.ParserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MasterManager {

    @Autowired
    private ParserController parserController;


    @PostConstruct
    public void init(){
        System.out.println("HUZZAH!!");
    }

}
