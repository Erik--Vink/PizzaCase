package com.infosupport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Created by Erik on 27-10-2016.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Named
@Entity
public class Pizza {
    @Id private int pizzaId;
    private String name;
    private double price;
    private String ingredients;
    private boolean edited;

    public Pizza(int id){
        this.pizzaId = id;
    }
}
