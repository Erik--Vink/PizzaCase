package com.infosupport.ejb;

import com.infosupport.entity.Pizza;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Erik on 31-10-2016.
 */
@Stateful
public class PizzaRequestBean {
    @PersistenceContext
    private EntityManager entityManager;

    public Pizza createPizza(int id, String name, double price, String ingredients){
        Pizza pizza = new Pizza(id);
        pizza.setName(name);
        pizza.setPrice(price);
        pizza.setIngredients(ingredients);
        pizza.setEdited(false);
        entityManager.persist(pizza);
        return pizza;
    }

    public List<Pizza> getAllPizzas(){
        TypedQuery<Pizza> query = entityManager.createQuery("SELECT p FROM Pizza p", Pizza.class);
        return query.getResultList();
    }
}
