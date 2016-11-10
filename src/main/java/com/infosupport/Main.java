package com.infosupport;

import com.infosupport.ejb.PizzaRequestBean;

import javax.xml.ws.Endpoint;

/**
 * Created by Erik on 31-10-2016.
 */
public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-derby");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        PizzaService service = new PizzaService(entityManager);
//
//        entityManager.getTransaction().begin();
//        Pizza pizza = service.createPizza(2, "Hawaii", 99.99, "Lots of tomatoes and ananas");
//        entityManager.getTransaction().commit();


//        CheckoutBean checkoutBean = new CheckoutBean();
//        checkoutBean.setCustomer(new Customer());
//        checkoutBean.submitOrder();

        final String url = "http://localhost:8888/hello";
//        http://localhost:8080/pizzaCase/PizzaServiceService?Tester
        System.out.println("Publishing RandService at endpoint " + url);
        Endpoint.publish(url, new PizzaRequestBean());

    }
}
