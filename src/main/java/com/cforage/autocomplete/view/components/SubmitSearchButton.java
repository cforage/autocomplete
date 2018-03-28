package com.cforage.autocomplete.view.components;

import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@UIScope
public class SubmitSearchButton extends Button {

    public SubmitSearchButton(){
        super("Submit");
    }


    @PostConstruct
    public void init(){
        addStyleName(ValoTheme.BUTTON_PRIMARY);

    }

}
