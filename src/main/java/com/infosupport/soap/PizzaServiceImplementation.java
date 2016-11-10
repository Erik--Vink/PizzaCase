package com.infosupport.soap;

import com.infosupport.ejb.PizzaRequestBean;
import com.infosupport.entity.Pizza;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "com.infosupport.soap.PizzaService")
public class PizzaServiceImplementation implements PizzaService {

    @EJB
    PizzaRequestBean pizzaRequestBean;

    @Override
    @WebMethod
    public List<Pizza> getAllPizzas() {
        System.out.println(pizzaRequestBean.getAll());
        List<Pizza> pizzas = pizzaRequestBean.getAll();
        return pizzaRequestBean.getAll();
    }
}
