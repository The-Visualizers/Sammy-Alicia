package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")

public class ProductTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // here we need to make the join with the Cart itself
    private Long id_product;
    // here we set the id_product to a Long
    private String name;
    // here we set the name to the field which is a string
    private String image;
    // image url for the front end
    private Integer price;
    // here we can adjust the price
    private boolean instock;
    // here we toggle the instock option
    private String description;
    // here we are able to create the form and save it as description
}
