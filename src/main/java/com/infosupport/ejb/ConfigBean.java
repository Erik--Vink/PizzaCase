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

@Singleton
@Startup
public class ConfigBean {

    @EJB
    private PizzaRequestBean pizzaRequestBean;

    @EJB
    private CustomerRequestBean customerRequestBean;

    @PostConstruct
    public void createData() {
        pizzaRequestBean.create("Hawai", 7.5, "Tomatoes, ananas...");
        pizzaRequestBean.create("Peperoni", 6.5, "Lots of tomatoes and ananas");
        pizzaRequestBean.create("Margaritha", 99.99, "Basic stuff");
        pizzaRequestBean.create("Salami", 99.99, "Lots of salami");
        pizzaRequestBean.create("Perfect pizza", 4.50, "It's just perfect");

        customerRequestBean.create("John Doe");
        customerRequestBean.create("Jane Doe");
    }
}
