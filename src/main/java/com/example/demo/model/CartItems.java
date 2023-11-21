package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "CARTITEMS")
public class CartItems {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer items_id;

@ManyToOne
@JoinColumn(name = "product_id")
int product_id;

@OneToOne
@JoinColumn(name="Cartid")
Cart cart;

}
