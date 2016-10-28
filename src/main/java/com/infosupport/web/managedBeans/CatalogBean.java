package com.infosupport.web.managedBeans;

import com.infosupport.collections.PizzaCollection;
import com.infosupport.entity.Pizza;

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

    private String sortDirection;

    public CatalogBean(){
        sortDirection = "asc";
    }
    public List<Pizza> getPizzas(){
        return PizzaCollection.getInstance().getPizzas();
    }

    public void updatePizza(Pizza pizza){
        PizzaCollection.getInstance().updatePizza(pizza);
    }

    public void deletePizza(Pizza pizza){
        PizzaCollection.getInstance().deletePizza(pizza);
    }

    public void savePizzas(){
        PizzaCollection.getInstance().savePizzas();
    }

    public String sortPizzasByName(){
        sortDirection = sortDirection.equals("asc")? "desc" : "asc";
        Collections.sort(getPizzas(), (key_1, key_2) -> {
            if (sortDirection.equals("asc")) {
                return key_1.getName().
                        compareTo(key_2.getName());
            } else {
                return key_2.getName().compareTo(key_1.getName());
            }
        });
        return null;
    }

    public String sortPizzasByPrice() {
        sortDirection = sortDirection.equals("asc") ? "desc" : "asc";
        Collections.sort(getPizzas(), (key_1, key_2) -> (sortDirection.equals("asc") ? 1 : -1) * ((int) key_1.getPrice() - (int) key_2.getPrice()));
        return null;
    }
}
