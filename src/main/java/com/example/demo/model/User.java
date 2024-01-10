package com.example.demo.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
   
    @Column(unique = true)
    private String email;
    
    @Column(nullable=false)
    private String username;

    @Column(unique = true)
    private String password;
    @Entity
    public class Cart {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int cart;

        private Date CreatedDate;

        private int userId;
        
        public Cart (Date CreatedDate, int id){
            this.CreatedDate = CreatedDate;
            this.userId = id;
        }

        public Date getCreatedDate() {
            return this.CreatedDate;
        }
        public int getId(){
            return this.userId;
        }

    }

    
}
