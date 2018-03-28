package com.cforage.autocomplete.view.components;

import com.cforage.autocomplete.controller.ProductController;
import com.cforage.autocomplete.model.Product;
import com.vaadin.data.HasValue;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@UIScope
public class SearchInputBox extends TextField{


    public SearchInputBox(){
        super("Search product catalogue");
    }


    @Autowired
    private ProductController productController;

    @Autowired
    private SuggestionViewer suggestionViewer;

    public void updateSuggestions(String s){

        System.out.println(s);
    }


    @PostConstruct
    public void init(){

        setPlaceholder("Ex. Little Big Planet");

        ValueChangeListener listener = new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent valueChangeEvent) {
                //don't populate autocomplete grid if only 1 character is typed in.
                if(getValue().length() < 2) return;

                List<Product> products = productController.find(getValue().toString());
                suggestionViewer.update(products);
                products.forEach(product -> System.out.println(product));
            }
        };

        addValueChangeListener(listener);

    }


}
