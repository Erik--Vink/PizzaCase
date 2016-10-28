package com.infosupport.collections;

import com.infosupport.entity.Pizza;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class PizzaCollection {
    private static PizzaCollection pizzaCollection;
    private static List<Pizza> pizzas;

    private PizzaCollection(){
        pizzas = new ArrayList<>();
        pizzas.add(Pizza.builder().name("Hawaii").price(7.5).pizzaId(1).build());
        pizzas.add(Pizza.builder().name("Pepperoni").price(5.0).pizzaId(2).build());
        pizzas.add(Pizza.builder().name("Salami").price(5.5).pizzaId(3).build());
    }

    public static PizzaCollection getInstance(){
        if(pizzaCollection == null){
            pizzaCollection = new PizzaCollection();
        }
        return pizzaCollection;
    }

    public void deletePizza(Pizza pizza){
        pizzas.remove(pizza);
    }

    public void updatePizza(Pizza pizza){
        pizza.setEdited(true);
    }

    public void savePizzas(){
        for(Pizza p : pizzas){
            p.setEdited(false);
        }
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }
}
