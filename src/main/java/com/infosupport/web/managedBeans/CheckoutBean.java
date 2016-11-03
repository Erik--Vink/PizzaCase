package com.infosupport.web.managedBeans;

import com.infosupport.ejb.CustomerRequestBean;
import com.infosupport.ejb.OrderRequestBean;
import com.infosupport.ejb.PizzaRequestBean;
import com.infosupport.entity.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named("checkout")
public class CheckoutBean implements Serializable {
    @Getter @Setter
    private Customer customer;

    @Inject
    ShoppingCart cart;

    @EJB
    CustomerRequestBean customerRequestBean;

    @EJB
    OrderRequestBean orderRequestBean;

    public CheckoutBean(){
        this.customer = new Customer();
    }

    public String submitOrder(){
        Customer customer = customerRequestBean.create(this.customer);
        orderRequestBean.create(cart.getOrderItems(), customer, cart.getTotal());
        return "catalog";
    }
}
