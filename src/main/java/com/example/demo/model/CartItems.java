package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CARTITEMS")
public class CartItems {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@JoinColumn(name = "id_product")
private Integer id_cartItems;
}

