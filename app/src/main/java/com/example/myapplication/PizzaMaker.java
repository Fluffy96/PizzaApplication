/**
 * This class creates pizzas that are requested by the user

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;

import java.io.Serializable;
import java.util.Locale;

/**
 *This class makes pizza of different types
 */
public class PizzaMaker implements Serializable {

    /**
     * This method creates a small pizza with the input flavor
     * @param flavor
     * @return
     */
    public static Pizza createPizza(String flavor){
        switch (flavor.toLowerCase()){
            case "deluxe":
                return new Deluxe("small");
            case "hawaiian":
                return new Hawaiian("small");
            case "pepperoni":
                return new Pepperoni("small");
            default:
                return new Deluxe("small");
        }
    }
}
