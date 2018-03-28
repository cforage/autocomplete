package com.cforage.autocomplete.view.components;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@UIScope
public class HomeTitle extends Label{


    public HomeTitle(){
        super("Product Viewer");
    }


    @PostConstruct
    public void init(){
        addStyleName(ValoTheme.LABEL_H1);


    }

}
