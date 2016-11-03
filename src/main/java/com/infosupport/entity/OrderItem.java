package com.infosupport.entity;

import com.infosupport.web.managedBeans.ShoppingCart;
import com.infosupport.web.managedBeans.ShoppingCartItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Erik on 1-11-2016.
 */
@Entity
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    private int quantity;

    @ManyToOne
    private Pizza pizza;

    public OrderItem(ShoppingCartItem shoppingCartItem){
        quantity = shoppingCartItem.getQuantity();
        pizza = (Pizza) shoppingCartItem.getItem();
    }
}
