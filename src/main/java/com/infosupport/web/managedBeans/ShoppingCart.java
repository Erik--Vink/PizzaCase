package com.infosupport.web.managedBeans;

import com.infosupport.entity.OrderItem;
import com.infosupport.entity.Pizza;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Created by Erik on 27-10-2016.
 */
@Named("cart")
@SessionScoped
public class ShoppingCart implements Serializable{
    HashMap<Integer, ShoppingCartItem> items = null;
    int numberOfItems = 0;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public synchronized void add(Integer pizzaId, Pizza pizza) {
        if (items.containsKey(pizzaId)) {
            ShoppingCartItem shoppingCartItem = (ShoppingCartItem) items.get(pizzaId);
            shoppingCartItem.incrementQuantity();
        } else {
            ShoppingCartItem newItem = new ShoppingCartItem(pizza);
            items.put(pizzaId, newItem);
        }
    }

    public synchronized List<ShoppingCartItem> getItems() {
        List<ShoppingCartItem> results = new ArrayList<>();
        results.addAll(this.items.values());

        return results;
    }

    public synchronized List<OrderItem> getOrderItems(){
        return items.keySet().stream().map(key -> new OrderItem(items.get(key))).collect(Collectors.toList());
    }

    public synchronized int getNumberOfItems() {
        numberOfItems = 0;
        for (ShoppingCartItem item : getItems()) {
            numberOfItems += item.getQuantity();
        }

        return numberOfItems;
    }

    public synchronized void incrementShoppingCartItemQuantity(ShoppingCartItem shoppingCartItem){
        shoppingCartItem.incrementQuantity();
    }

    public synchronized void decrementShoppingCartItemQuantity(ShoppingCartItem shoppingCartItem){
        shoppingCartItem.decrementQuantity();

        if(shoppingCartItem.getQuantity() < 1){
            Pizza pizza = (Pizza) shoppingCartItem.getItem();
            remove(pizza.getPizzaId());
        }
    }

    public synchronized void remove(int itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            numberOfItems--;
        }
    }

    public synchronized double getTotal() {
        double amount = 0.0;
        for (ShoppingCartItem item : getItems()) {
            Pizza pizza = (Pizza) item.getItem();

            amount += (item.getQuantity() * pizza.getPrice());
        }

        return roundOff(amount);
    }

    private double roundOff(double x) {
        long val = Math.round(x * 100); // cents

        return val / 100.0;
    }
//
//    /**
//     * <p>Buy the items currently in the shopping cart.</p>
//     * @return the navigation page
//     */
//    public String buy() {
//        // "Cannot happen" sanity check
//        if (getNumberOfItems() < 1) {
//            message(null, "CartEmpty");
//
//            return (null);
//        } else {
//            return ("bookcashier");
//        }
//    }
//
//    public synchronized void clear() {
//        logger.log(Level.INFO, "Clearing cart.");
//        items.clear();
//        numberOfItems = 0;
//        message(null, "CartCleared");
//    }
}
