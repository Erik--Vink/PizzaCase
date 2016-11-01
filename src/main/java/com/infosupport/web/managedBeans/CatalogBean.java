package com.infosupport.web.managedBeans;

import com.infosupport.collections.PizzaCollection;
import com.infosupport.ejb.PizzaRequestBean;
import com.infosupport.entity.Pizza;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SessionScoped
@Named("catalog")
public class CatalogBean implements Serializable{
    @Inject
    ShoppingCart cart;

    @EJB
    PizzaRequestBean pizzaRequestBean;

    public List<Pizza> getPizzas(){
        return pizzaRequestBean.getAll();
    }
}
