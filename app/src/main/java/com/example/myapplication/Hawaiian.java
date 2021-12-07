/**
 * This class is the subclass of Pizza for a Hawaiian Pizza

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
package com.example.myapplication;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Creates Hawaaian type pizza
 */
public class Hawaiian extends Pizza implements Serializable {

    public static final double BASEPRICE = 10.99;
    public static final int MINTOPPINGS = 2;
    public static final DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Constructor method of the Hawaiian class that creates a Hawaiian Pizza Object with an input of preferred size
     * @param pSize
     */
    Hawaiian(String pSize){
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
        toppings.add(Topping.PINEAPPLE);
        toppings.add(Topping.HAM);
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
     * This method sets the price of a pizza
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
     * This method returns all the unused toppings
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
     * This method returns all the toppings
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
     * This method sets the toppings of the pizza
     * @param tops
     */
    @Override
    public void setToppings(ArrayList <Topping> tops) {
        toppings = tops;
    }

    /**
     * This method returns the String value of the Hawaiian Object
     * @return
     */
    @Override
    public String toString(){
        String out = "Hawaiian Pizza, ";
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
     * This changes the size of the pizza
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
