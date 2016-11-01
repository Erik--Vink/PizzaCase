package com.infosupport.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Erik on 1-11-2016.
 */
@Entity
@Table(name="CustomerOrder")
public class Order {
    @Id private int orderId;
}
