package com.example.demo.model;
// might need to update to the sql
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Cartid;
     
    @Column(name = "created_date")
    private Date createdDate;
    
    // Foreign key referencing the user associated with this cart
    @JoinColumn(name="user_id")
    @OneToOne
    private Long user_id;

    public Cart(Date date, Long user_id){
        this.createdDate = date;
        this.user_id = user_id;
    }
}
