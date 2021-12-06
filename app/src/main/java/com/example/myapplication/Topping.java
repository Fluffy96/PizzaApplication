package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

import java.io.Serializable;

/**
 * Creates object of type Topping
 */
public enum Topping implements Serializable {
    PEPPERONI, HAM, PINEAPPLE, OLIVES, CHICKEN, MUSHROOM, ONION;

    /**
     * Method takes in string of the topping and returns the topping object of the topping
     * @param top
     * @return Topping
     */
    public static Topping toTopping(String top){
        switch (top.toLowerCase()) {
            case "pepperoni":
                return Topping.PEPPERONI;
            case "ham":
                return Topping.HAM;
            case "pineapple":
                return Topping.PINEAPPLE;
            case "olives":
                return Topping.OLIVES;
            case "chicken":
                return Topping.CHICKEN;
            case "mushroom":
                return Topping.MUSHROOM;
            case "onion":
                return Topping.ONION;
            default:
                return null;
        }
    }
}
