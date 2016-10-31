/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package com.infosupport.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * <p>Singleton bean that initializes the book database for the bookstore
 * example.</p>
 */
@Singleton
@Startup
public class ConfigBean {

    @EJB
    private PizzaRequestBean request;

    @PostConstruct
    public void createData() {
        request.createPizza(1, "Hawai", 7.5, "Tomatoes, ananas...");
        request.createPizza(2, "Peperoni", 6.5, "Lots of tomatoes and ananas");
        request.createPizza(3, "Margaritha", 99.99, "Basic stuff");
        request.createPizza(4, "Salami", 99.99, "Lots of salami");
    }
}
