/**
 * This class is the Orders class
 *  - Control a list of pizza orders for a given customer

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Class  defines the order object
 */
public class Order implements Serializable {
    private String phoneNum;
    private ArrayList<Pizza> pizzaList = new ArrayList<>();
    private double price = 0;

    /**
     * This constructor creates an Orders object with a given customer phone number
     * @param phoneNu
     */
    public Order(String phoneNu){
        phoneNum = phoneNu;
    }

    /**
     * This the default constructor which creates an Orders object
     */
    public Order(){

    }

    /**
     * This method adds a pizza to the order
     * @param piz
     * @param pric
     */
    public void addPizza(Pizza piz, double pric){
        pizzaList.add(piz);
        price = price + pric;
    }

    /**
     * This method returns the pizzaList
     * @return
     */
    public  ArrayList<Pizza> getPizzaList(){
        if(pizzaList.size() != -1){
            return pizzaList;
        }else{
            return null;
        }
    }

    /**
     * This method returns the price of the current Orders Object
     * @return price
     */
    public double getPrice(){
        return price;
    }

    /**
     * This method removes a pizza from order
     * @param piz
     */
    public void removePizza(Pizza piz){
        pizzaList.remove(piz);
    }

    /**
     * This method returns the phoneNum of the order
     * @return
     */
    public String getPhoneNum(){
        return phoneNum;
    }


}
