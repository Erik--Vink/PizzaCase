/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package com.infosupport.ejb;

import com.infosupport.entity.Customer;
import com.infosupport.entity.Pizza;
import com.infosupport.web.managedBeans.ShoppingCart;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ConfigBean {

    @EJB
    private PizzaRequestBean pizzaRequestBean;

    @EJB
    private CustomerRequestBean customerRequestBean;

    @EJB
    private OrderRequestBean orderRequestBean;

    @PostConstruct
    public void createData() {
        Pizza pizza1 = pizzaRequestBean.create("Hawai", 7.5, "Tomatoes, ananas...");
        Pizza pizza2 = pizzaRequestBean.create("Peperoni", 6.5, "Lots of tomatoes and ananas");
        Pizza pizza3 = pizzaRequestBean.create("Margaritha", 99.99, "Basic stuff");
        Pizza pizza4 = pizzaRequestBean.create("Salami", 99.99, "Lots of salami");
        Pizza pizza5 = pizzaRequestBean.create("Perfect pizza", 4.50, "It's just perfect");

        Customer customer1 = customerRequestBean.create("John Doe");
        Customer customer2 = customerRequestBean.create("Jane Doe");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.add(pizza1.getPizzaId(), pizza1);
        shoppingCart1.add(pizza2.getPizzaId(), pizza2);
        shoppingCart1.add(pizza1.getPizzaId(), pizza1);

        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.add(pizza3.getPizzaId(), pizza3);
        shoppingCart2.add(pizza4.getPizzaId(), pizza4);
        shoppingCart2.add(pizza5.getPizzaId(), pizza5);
        shoppingCart2.add(pizza5.getPizzaId(), pizza5);
        shoppingCart2.add(pizza5.getPizzaId(), pizza5);

        orderRequestBean.create(shoppingCart1.getOrderItems(), customer1, shoppingCart1.getTotal());
//        orderRequestBean.create(shoppingCart2.getOrderItems(), customer2, shoppingCart2.getTotal());
    }
}
