/**
 * This class is the controller class for the main page .fxml (hello-view.fxml)

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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {

    private static final int PIZZABUILDWIDTH = 550, PIZZABUILDHEIGHT = 525, CURRENTORDERWIDTH = 600, CURRENTORDERHEIGHT = 400, STOREORDERWIDTH = 600, STOREORDERHEIGHT = 400, NUMBERLENGTH = 10;
    @FXML
    private TextField cNum;
    @FXML
    private ListView<String> deluxeAdditional, deluxeToppings, pepperoniAdditional, pepperoniToppings, hawaiianAdditional, hawaiianToppings;
    private Orders order = new Orders();
    private StoreOrders storeOrder = new StoreOrders();
    private String phoneNumber = "";

    /**
     * This is the on click action for a Deluxe Pizza request
     */
    @FXML
    protected void onDeluxeClick() {
        String result = cNum.getText();
        Parent root;
        if (result.matches("[0-9]+")) {
            if (result.length() == NUMBERLENGTH) {
                if (phoneNumber == "") {
                    order = new Orders(result);
                    phoneNumber = result;
                } else {
                    if (!result.equals(order.getPhoneNum())) {
                        order = new Orders(result);
                        phoneNumber = result;
                    }
                }
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("deluxe-view.fxml"));
                try {
                    Loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DeluxeController deluxe = Loader.getController();
                deluxe.setCustomerAndNumber(phoneNumber, "deluxe", order);
                root = Loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Customize Your Pizza");
                stage.setScene(new Scene(root, PIZZABUILDWIDTH, PIZZABUILDHEIGHT));
                stage.setResizable(false);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!!");
                alert.setHeaderText("Phone Number Entered is not 10 Digits");
                alert.setContentText("Please enter valid Phone Number.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No Phone Number Entered");
            alert.setContentText("Please enter Phone Number.");
            alert.showAndWait();
        }
    }

    /**
     * This is the on click action for a Hawaiian Pizza request
     */
    @FXML
    protected void onHawaiianClick() {
        String result = cNum.getText();
        Parent root;
        if (result.matches("[0-9]+")) {
            if (result.length() == NUMBERLENGTH) {
                if (phoneNumber == "") {
                    order = new Orders(result);
                    phoneNumber = result;
                } else {
                    if (!result.equals(order.getPhoneNum())) {
                        order = new Orders(result);
                        phoneNumber = result;
                    }
                }
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("deluxe-view.fxml"));
                try {
                    Loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                DeluxeController deluxe = Loader.getController();
                deluxe.setCustomerAndNumber(phoneNumber, "hawaiian", order);
                root = Loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Customize Your Pizza");
                stage.setScene(new Scene(root, PIZZABUILDWIDTH, PIZZABUILDHEIGHT));
                stage.setResizable(false);
                stage.show();


            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!!");
                alert.setHeaderText("Phone Number Entered is not 10 Digits");
                alert.setContentText("Please enter valid Phone Number.");
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No Phone Number Entered");
            alert.setContentText("Please enter Phone Number.");
            alert.showAndWait();
        }

    }

    /**
     * This is the on click action for a Pepperoni Pizza request
     */
    @FXML
    protected void onPepperoniClick() {
        String result = cNum.getText();
        Parent root;
        if (result.matches("[0-9]+")) {
            if (result.length() == NUMBERLENGTH) {
                if (result.length() == NUMBERLENGTH) {
                    if (phoneNumber == "") {
                        order = new Orders(result);
                        phoneNumber = result;
                    } else {
                        if (!result.equals(order.getPhoneNum())) {
                            order = new Orders(result);
                            phoneNumber = result;
                        }
                    }
                    FXMLLoader Loader = new FXMLLoader();
                    Loader.setLocation(getClass().getResource("deluxe-view.fxml"));
                    try {
                        Loader.load();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    DeluxeController deluxe = Loader.getController();
                    deluxe.setCustomerAndNumber(phoneNumber, "pepperoni", order);
                    root = Loader.getRoot();
                    Stage stage = new Stage();
                    stage.setTitle("Customize Your Pizza");
                    stage.setScene(new Scene(root, PIZZABUILDWIDTH, PIZZABUILDHEIGHT));
                    stage.setResizable(false);
                    stage.show();


                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!!");
                    alert.setHeaderText("Phone Number Entered is not 10 Digits");
                    alert.setContentText("Please enter valid Phone Number.");
                    alert.showAndWait();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!!");
                alert.setHeaderText("No Phone Number Entered");
                alert.setContentText("Please enter Phone Number.");
                alert.showAndWait();
            }
        }
    }

    /**
     * This is the on click action for a current order request
     */
    @FXML
    protected void onCurrentOrderClick() {
        String result = cNum.getText();
        Parent root;
        if (result.matches("[0-9]+")) {
            if (result.length() == NUMBERLENGTH) {
                if (phoneNumber == "") {
                    order = new Orders(result);
                    phoneNumber = result;
                } else {
                    if (!result.equals(order.getPhoneNum())) {
                        order = new Orders(result);
                        phoneNumber = result;
                    }
                }
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("currentorder-view.fxml"));
                try {
                    Loader.load();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                CurrentOrderController cuurent = Loader.getController();
                cuurent.setCustomerAndNumber(order,storeOrder);
                root = Loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Customize Your Pizza");
                stage.setScene(new Scene(root, PIZZABUILDWIDTH, PIZZABUILDHEIGHT));
                stage.setResizable(false);
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning!!");
                alert.setHeaderText("Phone Number Entered is not 10 Digits");
                alert.setContentText("Please enter valid Phone Number.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!!");
            alert.setHeaderText("No Phone Number Entered");
            alert.setContentText("Please enter Phone Number.");
            alert.showAndWait();
        }

    }

    /**
     * This is the on click action for a store orders request
     */
    @FXML
    protected void onStoreOrderClick() {
        Parent root;
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("storeorders-view.fxml"));
        try {
            Loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        StoreOrdersController deluxe = Loader.getController();
        deluxe.setCustomerAndNumber(storeOrder);
        root = Loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(root, STOREORDERWIDTH, STOREORDERHEIGHT));
        stage.setResizable(false);
        stage.show();

    }

}