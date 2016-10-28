package com.infosupport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;

/**
 * Created by Erik on 27-10-2016.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Named
public class Pizza {
    private int pizzaId;
    private String name;
    private double price;
    private ArrayList<Ingredient> ingredients;
    private boolean edited;
}
