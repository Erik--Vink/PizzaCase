package com.infosupport.web.managedBeans;

import com.infosupport.entity.Pizza;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Erik on 27-10-2016.
 */
@Named("cart")
@SessionScoped
public class ShoppingCart implements Serializable{
    HashMap<String, ShoppingCartItem> items = null;
    int numberOfItems = 0;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public synchronized void add(String pizzaId, Pizza pizza) {
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

    public synchronized int getNumberOfItems() {
        numberOfItems = 0;
        for (ShoppingCartItem item : getItems()) {
            numberOfItems += item.getQuantity();
        }

        return numberOfItems;
    }

//    public synchronized void remove(String bookId) {
//        if (items.containsKey(bookId)) {
//            ShoppingCartItem scitem = (ShoppingCartItem) items.get(bookId);
//            scitem.decrementQuantity();
//
//            if (scitem.getQuantity() <= 0) {
//                items.remove(bookId);
//            }
//
//            numberOfItems--;
//        }
//    }
//

//

//
//    public synchronized double getTotal() {
//        double amount = 0.0;
//        for (ShoppingCartItem item : getItems()) {
//            Book bookDetails = (Book) item.getItem();
//
//            amount += (item.getQuantity() * bookDetails.getPrice());
//        }
//
//        return roundOff(amount);
//    }
//
//    private double roundOff(double x) {
//        long val = Math.round(x * 100); // cents
//
//        return val / 100.0;
//    }
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
