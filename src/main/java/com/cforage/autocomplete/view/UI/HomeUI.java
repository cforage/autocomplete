package com.cforage.autocomplete.view.UI;

import com.cforage.autocomplete.view.HomeView;
import com.cforage.autocomplete.view.components.ViewContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@SpringUI(path="/")
@Configuration
@UIScope

public class HomeUI extends UI {


    @Autowired
    private HomeView homeView;

    @Autowired
    private ViewContainer viewContainer;

    @Autowired
    private SpringViewProvider springViewProvider;

    private Navigator navigator;

    @PostConstruct
    public void init(){

        navigator = new Navigator(this, viewContainer);
        navigator.addProvider(springViewProvider);
    }

    public void navTo(String viewName){

        navigator.navigateTo(viewName);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest){

        setContent(viewContainer);
        navTo("home");

    }


}
