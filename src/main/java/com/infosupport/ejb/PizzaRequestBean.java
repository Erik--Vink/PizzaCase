package com.infosupport.ejb;

import com.infosupport.entity.Pizza;

import javax.ejb.Stateful;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Erik on 31-10-2016.
 */
@Stateful
@WebService(serviceName="PizzaService")
public class PizzaRequestBean {
    @PersistenceContext
    private EntityManager entityManager;

    @WebMethod(operationName = "create")
    public Pizza create(String name, double price, String ingredients){
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setPrice(price);
        pizza.setIngredients(ingredients);
        entityManager.persist(pizza);
        entityManager.flush();
        return pizza;
    }

    @WebMethod(operationName="getAll")
    public List<Pizza> getAll(){
        TypedQuery<Pizza> query = entityManager.createQuery("SELECT p FROM Pizza p", Pizza.class);
        return query.getResultList();
    }

    public Pizza update(Pizza pizza) throws Exception{
        Pizza existingPizza = entityManager.find(Pizza.class, pizza.getPizzaId());
        if (existingPizza == null) {
            throw new Exception("Entity does not exist");
        }
        entityManager.persist(pizza);
        return pizza;
    }
}
