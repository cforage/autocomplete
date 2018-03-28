package com.cforage.autocomplete.view.components;


import com.cforage.autocomplete.model.Product;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@UIScope
public class SuggestionViewer extends Grid<Product> {

    @PostConstruct
    public void init(){
        addColumn(Product::getName).setCaption("Available Product");
        addColumn(Product::getSku).setCaption("Product SKU");
    }

    public void update(List<Product> productList){
        getEditor().setEnabled(false);
        getEditor().setEnabled(true);
        setItems(productList);
        getEditor().setEnabled(false);
        getEditor().setEnabled(true);
    }
}
