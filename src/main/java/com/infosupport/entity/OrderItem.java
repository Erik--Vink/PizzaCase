package com.infosupport.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Erik on 1-11-2016.
 */
@Entity
@Table(name="PizzaOrder")
public class OrderItem {
    @Id private int orderId;

}
