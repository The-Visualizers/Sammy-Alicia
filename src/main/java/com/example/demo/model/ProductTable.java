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
@Table(name ="PRODUCT")

public class ProductTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //here we need to make the join with the Cart itself
    private Long id_product;
    
    private String name;

    private String image;

    private Integer price;

    private boolean instock;
    
    private String description;
}

         