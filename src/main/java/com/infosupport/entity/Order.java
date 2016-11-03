package com.infosupport.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Erik on 1-11-2016.
 */
@Entity
@Table(name="PizzaOrder")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String status;
    private double totalPrice;

    @OneToMany(cascade = CascadeType.PERSIST)
    Collection<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;
}
