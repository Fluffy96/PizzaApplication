/**
 * This class is an Enum that has the 3 different sizes of pizza

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

/**
 * Method for size object
 */
public enum Size {
    SMALL(0.00), MEDIUM(2.00), LARGE(4.00);

    private double price;

    /**
     * Sets price
     * @param price
     */
    Size(double price){
        this.price = price;
    }

    /**
     * Returns price
     * @return price
     */
    public double getPrice(){
        return this.price;
    }
}
