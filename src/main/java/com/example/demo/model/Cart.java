package com.example.demo.model;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="cart")
public class Cart {
    private int id;
    private int userId;
    private String orderStatus;
    private String sessionId;
}
