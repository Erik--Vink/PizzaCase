package com.infosupport.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Named;
import javax.persistence.*;

/**
 * Created by Erik on 27-10-2016.
 */
@NoArgsConstructor
@Data
@Named
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pizzaId;
    private String name;
    private double price;
    private String ingredients;

    public Pizza(String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }
}
