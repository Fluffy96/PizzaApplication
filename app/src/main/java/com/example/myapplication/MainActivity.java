package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class runs the opening page of the gui
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_CODE = 1;
    private TextView phoneNumber;
    private ImageView deluxePizza, hawaiianPizza, pepperoniPizza, cOrder, sOrder;
    private Order order;
    private StoreOrders storeOrders = new StoreOrders();
    private double currentOrderTotal;
    private String currentNumber;
    private ArrayList<Order> sto = new ArrayList<Order>();
    private static final int ONE = 1, TWO = 2, THREE = 3, NEG = -1, PHONELENGTH = 10;

    /**
     * Method sets up the images on the parent gui page
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setText(currentNumber);
    }

    /**
     * Gui for when deluxe pizza photo is click
     * @param view
     */
    public void onDeluxeClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "deluxe";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            if(order == null || !(order.getPhoneNum().contentEquals(phoneNumber.getText()))) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

    /**
     * Gui for when Hawaiian pizza photo is click
     * @param view
     */
    public void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            if(order == null || !(order.getPhoneNum().contentEquals(phoneNumber.getText()))) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

    /**
     * Gui for when Pepperonni click
     * @param view
     */
    public void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            if(order == null || !(order.getPhoneNum().contentEquals(phoneNumber.getText()))) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

    /**
     * Gui for when current orders is clicked
     * @param view
     */
    public void onCOrderClick(View view){
        if(order!= null) {
            Intent intent = new Intent(this, CurrentOrderActivity.class);
            intent.putExtra("NUMBER", phoneNumber.getText());
            if (numberChecker(phoneNumber)) {
                intent.putExtra("NUMBER", order.getPhoneNum());
                intent.putExtra("Order", order);
                intent.putExtra("StoreOrders", storeOrders);
                this.startActivityForResult(intent, TWO);
            }
        }else{
            Toast.makeText(getApplicationContext(),"Add pizzas to order first",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * For when store order is clicked
     * @param view
     */
    public void onSOrderClick(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        intent.putExtra("NUMBER", phoneNumber.getText()); //might not need
        intent.putExtra("storeOrders", storeOrders);
        //if(numberChecker(phoneNumber)) {
            intent.putExtra("StoreOrders", storeOrders);
            this.startActivityForResult(intent, THREE);
        //}
    }

    /**
     * Sets up main gui after you come back from deluxe, hawaiian, or pepperoni click
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ONE){
            order = (Order) data.getSerializableExtra("order");
        }
        if(requestCode == TWO){

            System.out.println(order.getPizzaList().toString());
            sto.add((Order)data.getSerializableExtra("order"));

            System.out.println("hi"+sto.get(0).getPhoneNum());
        }
        if(requestCode == THREE){
            storeOrders = (StoreOrders) data.getSerializableExtra("storeOrders");
            ArrayList<String> numList = storeOrders.getPhoneNumberList();
            Toast.makeText(getApplicationContext(),(numList.isEmpty())?"NumList Empty":numList.get(0),Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Makes sure that length of the phone number is atleast 10 digits long
     * @param t
     * @return
     */
    public boolean numberChecker(TextView t){
        String num = t.getText().toString();
        if(num.length() == PHONELENGTH){
            return true;
        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid Phone Number",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    /**
     * Selects items
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * if nothing is clicked
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}