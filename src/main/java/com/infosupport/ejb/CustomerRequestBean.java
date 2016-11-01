package com.infosupport.ejb;

import com.infosupport.entity.Customer;
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
public class CustomerRequestBean {
    @PersistenceContext
    private EntityManager entityManager;

    public Customer create(int id, String name){
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setName(name);
        entityManager.persist(customer);
        return customer;
    }

    public List<Customer> getAll(){
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
        return query.getResultList();
    }
}
