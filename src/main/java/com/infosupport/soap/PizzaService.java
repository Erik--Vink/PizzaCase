package com.infosupport.soap;

import com.infosupport.entity.Pizza;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Erik on 10-11-2016.
 */
@WebService
public interface PizzaService {

    @WebMethod
    List<Pizza> getAllPizzas();
}
