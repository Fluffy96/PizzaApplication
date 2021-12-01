/**
 * This class is the subclass of Pizza for a Deluxe Pizza

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;

import java.util.ArrayList;
//import  proj4.project4.Topping;

public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;
    //public enum Topping {PEPPERONI, HAM, PINEAPPLE, OLIVES, CHICKEN, MUSHROOM, ONION};
    /*public enum Size {
        SMALL(0.00), MEDIUM(2.00), LARGE(4.00);
        private double price;
        Size(double price){
            this.price = price;
        }
        public double getPrice(){
            return this.price;
        }
    };*/
    public static final double PERTOPPING = 1.49;
    public static final int NOTFOUND = -1;
    public double pizzaPrice = 0;

    /**
     * This method returns the price of the pizza object
     * @return
     */
    public abstract double getprice();

    /**
     * This method sets the price of the pizza
     * @param cost
     */
    public abstract void setprice(double cost);

    /**
     * This method adds a topping to the pizza
     * @param top
     */
    public abstract void addTopping(Topping top); //returns a string that says yes if it is able to return

    /**
     * This method removes a topping from the pizza
     * @param top
     */
    public abstract void removeTopping(Topping top);

    /**
     * This method sets the toppings for the pizza
     * @param tops
     */
    public abstract void setToppings(ArrayList<Topping> tops);

    /**
     * This method returns an ArrayList of unused toppings
     * @return
     */
    public abstract ArrayList<Topping> unusedToppings();

    /**
     * This method returns a String[] of the toppings
     * @return
     */
    public abstract String[] getTopppings();

    /**
     * This method returns a String of the pizza
     * @return
     */
    public abstract String toString();

    /**
     * This method returns the minimum number of toppings
     * @return
     */
    public abstract int getMinTop();

    /**
     * This method changes the size of a pizza
     * @param s
     */
    public abstract void changeSize(String s);

}
