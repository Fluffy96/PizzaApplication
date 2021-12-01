/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
package com.example.myapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller that handles store order gui
 */
public class StoreOrdersController {

    @FXML
    private MenuButton storeOrderPhoneNumber;
    @FXML
    private TextField StoreOrderTotal;
    @FXML
    ListView<String> storeOrderListView;
    private ArrayList<String> phoneNumbers = new ArrayList<>();
    private ArrayList<Double> cost = new ArrayList<>();
    private ArrayList<Orders> order = new ArrayList<>();
    private String numberClicked="";
    private StoreOrders sorder = new StoreOrders();

    /**
     * Method called in the hello controller class that passes store orders data to this controller
     * @param store
     */
    public void setCustomerAndNumber(StoreOrders store){
        sorder = store;
        phoneNumbers = sorder.getPhoneNumberList();
        order = sorder.getOrders();
        cost = sorder.getTotalPrices();
        for(int i =0; i<phoneNumbers.size();i++){
            MenuItem m1 = new MenuItem((phoneNumbers.get(i)));
            storeOrderPhoneNumber.getItems().add(m1);
            m1.setOnAction(event);
        }

    }

    /**
     * Method that creates event handlers for dynamically created menu items and adds pizzas owned by that number in the list view
     */
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            storeOrderListView.getItems().clear();
            ObservableList<String> currOrders = FXCollections.observableArrayList();
            numberClicked = ((MenuItem)e.getSource()).getText();
            int index = phoneNumbers.indexOf(numberClicked);
            StoreOrderTotal.setText(String.valueOf(cost.get(index)));
            StoreOrderTotal.setEditable(false);
            ArrayList<Pizza> list = order.get(index).getPizzaList();
            for (int i = 0; i < list.size(); i++) {
                currOrders.add(list.get(i).toString());
            }
            storeOrderListView.setItems(currOrders);


        }
    };

    /**
     * Method handles what happens when a pizza order is cancelled
     */
    @FXML
    protected void onCancelOrder(){
        StoreOrderTotal.clear();
        storeOrderListView.getItems().clear();
        sorder.removeOrder(numberClicked);
        phoneNumbers = sorder.getPhoneNumberList();
        order = sorder.getOrders();
        storeOrderPhoneNumber.getItems().clear();
        cost = sorder.getTotalPrices();
        for(int i =0; i<phoneNumbers.size();i++){
            MenuItem m1 = new MenuItem((phoneNumbers.get(i)));
            storeOrderPhoneNumber.getItems().add(m1);
            m1.setOnAction(event);
        }


    }

    /**
     * Exports all the orders into a text file
     */
    @FXML
    protected void onExportStoreOrders(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open a Target File to Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"), new FileChooser.ExtensionFilter("All Files", "*,*"));
        Stage stage = new Stage();
        File targetFile  = chooser.showSaveDialog(stage);
        FileWriter writer;
        if(targetFile!=null) {
            try {
                writer = new FileWriter(targetFile);
                for(int y = 0; y<phoneNumbers.size(); y++) {
                    writer.write("User Phone Number: "+phoneNumbers.get(y)+ System.lineSeparator());
                    for(int x = 0; x<order.get(y).getPizzaList().size(); x++) {
                        writer.write(order.get(y).getPizzaList().get(x)+ System.lineSeparator());
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
