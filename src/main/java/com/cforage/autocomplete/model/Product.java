package com.cforage.autocomplete.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Product {


        @Column
        @Id
        private String sku;

        @Column
        private String name;

}
