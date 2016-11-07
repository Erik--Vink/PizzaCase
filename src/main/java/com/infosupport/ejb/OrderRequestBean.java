package com.infosupport.ejb;

import com.infosupport.entity.Customer;
import com.infosupport.entity.Order;
import com.infosupport.entity.OrderItem;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * Created by Erik on 31-10-2016.
 */
@Stateful
public class OrderRequestBean {
    @PersistenceContext
    private EntityManager entityManager;

    public Order create(Collection<OrderItem> orderItems, Customer customer, double total){
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderItems(orderItems);
        order.setTotalPrice(total);
        entityManager.persist(order);
        entityManager.flush();
        return order;
    }

    public List<Order> getAll(){
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }
}
