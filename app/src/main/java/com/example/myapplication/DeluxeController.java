/**
 * This class is the controller of the deluxe-view.fxml

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DeluxeController {
    private ObservableList<String> selectTopping = FXCollections.observableArrayList ();
    private ObservableList<String> additionalTopping = FXCollections.observableArrayList ();
    @FXML
    private ListView<String> deluxeAdditional,deluxeToppings ;
    @FXML
    private MenuButton isSizeSelect;
    @FXML
    private TextField deluxePrice;
    @FXML
    private ImageView image;
    private String phoneNumber;
    private Pizza initialSmallPizza;
    private DecimalFormat df = new DecimalFormat("#.##");
    private final double SIZEINCREASE = 2;
    private String falvor;
    private Orders order;

    /**
     * This method sets the customers number and pizza flavor. Runs on launch
     * @param num - number of the customer
     * @param fal - type of pizza the customer wants
     * @param ord - the current order of the customer
     */
    public void setCustomerAndNumber(String num, String fal, Orders ord){
        order = ord;
        falvor = fal;
        if(fal == "deluxe"){
            image.setImage(new Image(getClass().getResourceAsStream("delPizza.jpg")));
        }else if (fal.toLowerCase().equals("hawaiian")){
            image.setImage(new Image(getClass().getResourceAsStream("hawaiianhampizza.jpg")));
        }else{
            image.setImage(new Image(getClass().getResourceAsStream("GettyImages-1133727757.jpg")));
        }
        deluxePrice.setEditable(false);
        phoneNumber = num;
        initialSmallPizza = PizzaMaker.createPizza(falvor);
        deluxeToppings.getItems().clear();
        deluxeAdditional.getItems().clear();
        selectTopping.addAll(initialSmallPizza.getTopppings());
        deluxeToppings.setItems(selectTopping);
        for(int i =0; i< initialSmallPizza.unusedToppings().size();i++){
            additionalTopping.add(initialSmallPizza.unusedToppings().get(i).toString());
        }
        deluxeAdditional.setItems(additionalTopping);
        isSizeSelect.setText("Small");
        deluxePrice.setText(String.valueOf(initialSmallPizza.getprice()));
    }

    /**
     * This method adds the selected topping to the pizza
     */
    @FXML
    protected void onAddTopping(){
        String selected = deluxeAdditional.getSelectionModel().getSelectedItem();
        if(deluxeAdditional.getItems().size()!=0 && selected!=null) {
            ObservableList<String> items = deluxeToppings.getItems();
            int len = items.size();
            if (!items.contains(selected) && len <= 7) {
                deluxeToppings.getItems().add(selected);
                initialSmallPizza.addTopping(Topping.toTopping(selected));
                deluxePrice.setText(df.format(initialSmallPizza.getprice()));
            }
            items = deluxeAdditional.getItems();
            len = items.size();
            if (items.contains(selected) && len > 0) {
                deluxeAdditional.getItems().remove(selected);
            }
        }
    }

    /**
     * This method removes the selected topping from the pizza
     */
    @FXML
    protected void onRemoveTopping(){
        String selected = deluxeToppings.getSelectionModel().getSelectedItem();
        if( selected!=null) {
            ObservableList<String> items = deluxeToppings.getItems();
            int len = items.size();
            if (items.contains(selected) && len > initialSmallPizza.getMinTop()) {
                deluxeToppings.getItems().remove(selected);
                initialSmallPizza.removeTopping(Topping.toTopping(selected));
                deluxePrice.setText(df.format(initialSmallPizza.getprice()));
            }
            items = deluxeAdditional.getItems();
            if (!items.contains(selected) && len > initialSmallPizza.getMinTop()) {
                deluxeAdditional.getItems().add(selected);
            }
        }
    }

    /**
     * This method adds a pizza to the current order
     */
    @FXML
    protected void onAdd(){
        order.addPizza(initialSmallPizza,initialSmallPizza.getprice());
        //NEED to make scene close!!!
    }

    /**
     * Method makes it so when the small pizza size is chosen price and pizza update to that of original deluxe pizza
     */
    @FXML
    private void setSmall(){
        deluxeToppings.getItems().clear();
        deluxeAdditional.getItems().clear();
        initialSmallPizza = PizzaMaker.createPizza(falvor);
        initialSmallPizza.changeSize("Small");
        selectTopping.addAll(initialSmallPizza.getTopppings());
        deluxeToppings.setItems(selectTopping);
        for(int i =0; i< initialSmallPizza.unusedToppings().size();i++){
            additionalTopping.add(initialSmallPizza.unusedToppings().get(i).toString());
        }
        deluxeAdditional.setItems(additionalTopping);
        isSizeSelect.setText("Small");
        deluxePrice.setText(df.format(initialSmallPizza.getprice()));
    }

    /**
     * Method makes it so when the medium pizza size is chosen price and pizza update to that of original deluxe pizza
     */
    @FXML
    private void setMedium(){
        deluxeToppings.getItems().clear();
        deluxeAdditional.getItems().clear();
        initialSmallPizza = PizzaMaker.createPizza(falvor);
        initialSmallPizza.changeSize("Medium");
        selectTopping.addAll(initialSmallPizza.getTopppings());
        deluxeToppings.setItems(selectTopping);
        for(int i =0; i< initialSmallPizza.unusedToppings().size();i++){
            additionalTopping.add(initialSmallPizza.unusedToppings().get(i).toString());
        }
        deluxeAdditional.setItems(additionalTopping);
        isSizeSelect.setText("Medium");
        deluxePrice.setText(df.format(initialSmallPizza.getprice()));
    }

    /**
     * Method makes it so when the large pizza size is chosen price and pizza update to that of original deluxe pizza
     */
    @FXML
    private void setLarge(){
        deluxeToppings.getItems().clear();
        deluxeAdditional.getItems().clear();
        initialSmallPizza = PizzaMaker.createPizza(falvor);
        initialSmallPizza.changeSize("Large");
        selectTopping.addAll(initialSmallPizza.getTopppings());
        deluxeToppings.setItems(selectTopping);
        for(int i =0; i< initialSmallPizza.unusedToppings().size();i++){
            additionalTopping.add(initialSmallPizza.unusedToppings().get(i).toString());
        }
        deluxeAdditional.setItems(additionalTopping);
        isSizeSelect.setText("Large");
        deluxePrice.setText(df.format(initialSmallPizza.getprice()));
    }

}
