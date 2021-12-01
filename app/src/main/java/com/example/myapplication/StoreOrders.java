/**
 * This class manages all of the orders from the store

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Store Order object method
 */
public class StoreOrders {

    private static ArrayList<ObservableList<Orders>> finalOrders = new ArrayList<>();
    private static ArrayList<Double> totalPrices = new ArrayList<>();
    private static ArrayList<Orders> orders = new ArrayList<>();
    private static ArrayList<String> phoneNumberList = new ArrayList<>();
    private static String currentNumber;
    private static final int NOEXSIST = -1;

    /**
     * Generic constructor method for StoreOrders
     */
    public StoreOrders(){
    }

    /**
     * Adds an order to the order arraylist
     * @param order
     */
    public void addOrders( Orders order){
        orders.add(order);
    }

    /**
     * Adds the Total Price of the order into the Total price array
     * @param totPrice
     */
    public void addTP(double totPrice){
        totalPrices.add(totPrice);
    }

    /**
     * Returns all orders that were added
     * @return Orders
     */
    public  ArrayList<Orders> getOrders() {
        return orders;
    }

    /**
     * Takes in an order that user wants to remove and removes it from the orders array
     * @param number
     */
    public void removeOrder(String number){
        int index = phoneNumberList.indexOf(number);
        phoneNumberList.remove(index);
        totalPrices.remove(index);
        orders.remove(index);
    }

    /**
     * Method returns to user the phonenumbers of all the orders
     * @return phonenUmberList
     */
    public  ArrayList<String> getPhoneNumberList() {
        return phoneNumberList;
    }

    /**
     * Adds a phone number of the order into the phone number array
     * @param num
     */
    public void addPhoneNumbers (String num){
        phoneNumberList.add(num);
    }

    /**
     * Method reurnts the tottal price arraylist
     * @return totalPrices
     */
    public  ArrayList<Double> getTotalPrices() {
        return totalPrices;
    }

    /**
     * Method returns whether a phone number is in orders
     * @param num
     * @return Boolean
     */
    public boolean isIn(String num){
        if(phoneNumberList.indexOf(num) != NOEXSIST){
             return true;
        }else{
            return false;
        }
    }

    /**
     * To String Method for Store Orders Object
     * @return
     */
    @Override
    public String toString(){
        return null;
    }
}
