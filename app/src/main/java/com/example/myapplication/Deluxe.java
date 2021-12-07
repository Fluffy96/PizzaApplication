/**
 * This class is the subclass of Pizza for a Deluxe Pizza

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
import java.util.Arrays;

/**
 * Class defines deluxe type pizza
 */
public class Deluxe extends Pizza implements Serializable {

    public static final double BASEPRICE = 12.99;
    public static final int MINTOPPINGS = 5;
    public static final DecimalFormat df = new DecimalFormat("#.##");

    /**
     * This is the constructor of Deluxe that creates a Deluxe type Pizza.
     * @param pSize
     */
    Deluxe(String pSize){
        if(pSize.toLowerCase().equals( "small")){
            size = Size.SMALL;
            double amount = BASEPRICE+size.getPrice();
            setprice(amount);
        }else if(pSize.toLowerCase().equals("medium")){
            size = Size.MEDIUM;
            double amount = BASEPRICE+size.getPrice();
            setprice(amount);
        }else{
            size = Size.LARGE;
            double amount = BASEPRICE+size.getPrice();
            setprice(amount);
        }
        Topping[] otherList = new Topping[] {Topping.MUSHROOM, Topping.CHICKEN, Topping.OLIVES, Topping.ONION, Topping.PEPPERONI};
        toppings.addAll(Arrays.asList(otherList));

    }

    /**
     * This method returns the price of the pizza.
     * @return pizzaPrice
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
     * This method allows the user to set the price of the pizza.
     * @param cost
     */
    @Override
    public void setprice(double cost) {
        pizzaPrice = cost;
    }

    /**
     * This method allows user to add a topping to the Deluxe Object
     * @param top
     */
    @Override
    public void addTopping(Topping top){
        toppings.add(top);
    }

    /**
     * This method allows user to remove a topping from the Deluxe Object
     * @param top
     */
    @Override
    public void removeTopping(Topping top){
        toppings.remove(top);
    }

    /**
     * This method allows the user to set the toppings with an ArrayList<Top>
     * @param tops
     */
    @Override
    public void setToppings(ArrayList <Topping> tops) {
        toppings = tops;
    }

    /**
     * This method returns a list of unused toppings
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
     * This method returns a String[] of toppings
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
     * This method return the toString of the Object
     * @return
     */
    @Override
    public String toString(){
        String out = "Deluxe Pizza, ";
        for(Topping top: toppings){
            out += top.toString()+", ";
        }
        out += size.toString()+", ";
        out += "$ ";
        out += df.format(pizzaPrice);
        return out;
    }

    /**
     * This method returns the minimum number of toppings for this pizza
     * @return
     */
    @Override
    public int getMinTop(){
        return MINTOPPINGS;
    }

    /**
     * This allows the user to change the size of the pizza
     * @param s
     */
    @Override
    public void changeSize(String s){
        if(s.toLowerCase().equals( "small")){
            size = Size.SMALL;
            double amount = BASEPRICE+size.getPrice();
            setprice(amount);
        }else if(s.toLowerCase().equals("medium")){
            size = Size.MEDIUM;
            double amount = BASEPRICE+size.getPrice();
            setprice(amount);
        }else{
            size = Size.LARGE;
            double amount = BASEPRICE+size.getPrice();
            setprice(amount);
        }
    };
}
