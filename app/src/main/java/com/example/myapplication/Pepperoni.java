/**
 * This class is the subclass of Pizza for a Pepperoni Pizza

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Pepperoni extends Pizza implements Serializable {

    public static final double BASEPRICE = 8.99;
    public static final int MINTOPPINGS = 1;
    public static final DecimalFormat df = new DecimalFormat("#.##");

    /**
     * This constructor creates a Pepperoni Pizza Object with the given size
     * @param pSize
     */
    Pepperoni(String pSize){
        if(pSize.toLowerCase().equals( "small")){
            size = Size.SMALL;
            setprice(BASEPRICE+size.getPrice());
        }else if(pSize.toLowerCase().equals("medium")){
                size = Size.MEDIUM;
                setprice(BASEPRICE+size.getPrice());
        }else{
            size = Size.LARGE;
            setprice(BASEPRICE+size.getPrice());
        }
        toppings.add(Topping.PEPPERONI);
    }

    /**
     * This method returns the price of the pizza
     * @return
     */
    @Override
    public double getprice() {
        double amount = BASEPRICE+size.getPrice();
        if(toppings.size()>MINTOPPINGS){
            amount += (toppings.size()-MINTOPPINGS)*PERTOPPING;
        }
        setprice(amount);
        return pizzaPrice;
    }

    /**
     * This method sets the price of the pizza
     * @param cost
     */
    @Override
    public void setprice(double cost) {
        pizzaPrice = cost;
    }

    /**
     * This method adds a topping to the pizza
     * @param top
     */
    @Override
    public void addTopping(Topping top){
        toppings.add(top);
    }

    /**
     * This method removes a topping from the pizza
     * @param top
     */
    @Override
    public void removeTopping(Topping top){
        toppings.remove(top);
    }

    /**
     * This method sets the toppings for the pizza
     * @param tops
     */
    @Override
    public void setToppings(ArrayList<Topping> tops) {
        toppings = tops;
    }

    /**
     * This method returns an ArrayList of unused toppings
     * @return
     */
    @Override
    public ArrayList<Topping> unusedToppings() {
        ArrayList<Topping> out = new ArrayList<>();
        for(Topping t: Topping.values()){
            out.add(t);
            if(toppings.contains(t)){
                out.remove(t);
            }
        }
        return out;
    }

    /**
     * This method returns a String[] of the toppings
     * @return
     */
    @Override
    public String[] getTopppings(){
        String[] topList = new String[toppings.size()];
        for(int i = 0; i < toppings.size();i++){
            topList[i] = toppings.get(i).toString();
        }
        return topList;
    }

    /**
     * This method returns a String of the pizza
     * @return
     */
    @Override
    public String toString(){
        String out = "Pepperoni Pizza, ";
        for(Topping top: toppings){
            out += top.toString()+", ";
        }
        out += size.toString()+", ";
        out += "$ ";
        out += df.format(pizzaPrice);
        return out;
    }

    /**
     * This method returns the minimum number of toppings
     * @return
     */
    @Override
    public int getMinTop(){
        return MINTOPPINGS;
    }

    /**
     * This method changes the size of a pizza
     * @param s
     */
    @Override
    public void changeSize(String s) {
        if (s.toLowerCase().equals("small")) {
            size = Size.SMALL;
            double amount = BASEPRICE + size.getPrice();
            setprice(amount);
        } else if (s.toLowerCase().equals("medium")) {
            size = Size.MEDIUM;
            double amount = BASEPRICE + size.getPrice();
            setprice(amount);
        } else {
            size = Size.LARGE;
            double amount = BASEPRICE + size.getPrice();
            setprice(amount);
        }
    }
}

