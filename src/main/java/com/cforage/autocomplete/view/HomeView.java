package com.cforage.autocomplete.view;

import com.cforage.autocomplete.view.components.HomeTitle;
import com.cforage.autocomplete.view.components.SearchInputBox;
import com.cforage.autocomplete.view.components.SubmitSearchButton;
import com.cforage.autocomplete.view.components.SuggestionViewer;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@UIScope
@SpringView(name= HomeView.VIEW_NAME)
public class HomeView extends VerticalLayout implements View {


    @Autowired
    private HomeTitle homeTitle;

    @Autowired
    private SearchInputBox searchInputField;

//    @Autowired
//    private SubmitSearchButton submitSearchButton;

    @Autowired
    private SuggestionViewer suggestionViewer;

    private HorizontalLayout sideBySide = new HorizontalLayout();

    public static final String VIEW_NAME = "home";


    @PostConstruct
    public void init(){

        addComponent(homeTitle);
        setComponentAlignment(homeTitle, Alignment.TOP_CENTER);

        addComponent(sideBySide);

        sideBySide.addComponent(searchInputField);

//        sideBySide.addComponent(submitSearchButton);

        sideBySide.addComponent(suggestionViewer);
    }
}
