package com.infosupport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Erik on 1-11-2016.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private String zipcode;
    private String houseNumber;
    private String street;
    private String city;

//    @OneToMany(mappedBy = "customer")
//    private Collection<Order> orders;
}
