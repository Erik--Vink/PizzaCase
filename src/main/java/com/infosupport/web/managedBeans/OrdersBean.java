package com.infosupport.web.managedBeans;

import com.infosupport.ejb.OrderRequestBean;
import com.infosupport.ejb.PizzaRequestBean;
import com.infosupport.entity.Order;
import com.infosupport.entity.Pizza;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("orders")
public class OrdersBean implements Serializable{
//    @Inject
//    ShoppingCart cart;

    @EJB
    OrderRequestBean orderRequestBean;

    public List<Order> getOrders(){
        return orderRequestBean.getAll();
    }
}
