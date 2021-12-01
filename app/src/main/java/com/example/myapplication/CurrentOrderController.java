/**
 * This class is the controller of the currentorder-view.fxml

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrentOrderController {

    private DecimalFormat df = new DecimalFormat("#.##");
    private Orders order = new Orders();
    private String phoneNumber;
    //@FXML
    private TextField currentOrderPhoneNumber,subtotal,currentOrderTotal,salestax;
    private ObservableList<String> currOrders = FXCollections.observableArrayList();
    //@FXML
    private ListView<String> currentOrderListView;
    private static final double TAX = .06625;
    private static final int NOT_FOUND = -1;
    private static final double NO_COST = 0.0;
    private StoreOrders storeOrders = new StoreOrders();

    /**
     * This method runs when the Current Order View is opened.
     * @param orde
     * @param stOrd
     */
    public void setCustomerAndNumber(Orders orde, StoreOrders stOrd){
        storeOrders = stOrd;
        order = orde;
        currentOrderPhoneNumber.setEditable(false);
        currentOrderPhoneNumber.setText(order.getPhoneNum());
        subtotal.setEditable(false);
        currentOrderTotal.setEditable(false);
        salestax.setEditable(false);
        phoneNumber = order.getPhoneNum();
        double cost = NO_COST;
        if(order.getPizzaList() != null) {
            ArrayList<Pizza> list  = order.getPizzaList();
            for (int i = 0; i < list.size(); i++) {
                currOrders.add(list.get(i).toString());
                cost = cost + list.get(i).getprice();
            }
            double tax = cost * TAX;
            double total = tax + cost;
            subtotal.setText(df.format(cost));
            currentOrderTotal.setText((df.format(total)));
            salestax.setText(df.format(tax));
            currentOrderListView.setItems(currOrders);
        }else{
            subtotal.setText(String.valueOf(NO_COST));
            salestax.setText(String.valueOf(NO_COST));
            currentOrderTotal.setText(String.valueOf(NO_COST));
        }


    }

    /**
     * This method removes the pizza the user has clicked on
     */
    @FXML
    protected void onRemovePizza(){
        int indexPizza = currentOrderListView.getSelectionModel().getSelectedIndex();
        if(indexPizza != NOT_FOUND){
            currentOrderListView.getItems().clear();
            order.removePizza(order.getPizzaList().get(indexPizza));
            double cost = NO_COST;
            ArrayList<Pizza> list  = order.getPizzaList();
            for(int i =0; i< list.size(); i++){
                currOrders.add(list.get(i).toString());
                cost = cost + list.get(i).getprice();
            }
            double tax = cost * TAX;
            double total = tax +cost;
            subtotal.setText(df.format(cost));
            currentOrderTotal.setText((df.format(total)));
            salestax.setText(df.format(tax));
        }

    }

    /**
     * This method places the current order displayed
     */
    @FXML
    protected void onPlaceOrder(){
        if(storeOrders.isIn(phoneNumber) == false) {
            storeOrders.addOrders(order);
            storeOrders.addTP(Double.parseDouble(currentOrderTotal.getText()));
            storeOrders.addPhoneNumbers(phoneNumber);
        }
    }

}
