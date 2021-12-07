package com.example.myapplication;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_CODE = 1;
    private TextView phoneNumber;
    private ImageView deluxePizza, hawaiianPizza, pepperoniPizza, cOrder, sOrder;
    private Order order=null;
    private StoreOrders storeOrders = new StoreOrders();
    private double currentOrderTotal;
    private String currentNumber;
    private static final int ONE = 1, TWO = 2, THREE = 3, NEG = -1, PHONELENGTH = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setText(currentNumber);
    }

    public void onDeluxeClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "deluxe";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            if(order == null || (order.getPhoneNum().equals(phoneNumber.getText()))) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

    public void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            if(order == null || (order.getPhoneNum().equals(phoneNumber.getText()))) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

    public void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            if(order == null || (order.getPhoneNum().equals(phoneNumber.getText()))) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

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

    public void onSOrderClick(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        intent.putExtra("NUMBER", phoneNumber.getText()); //might not need
        if(numberChecker(phoneNumber)) {
            intent.putExtra("StoreOrders", storeOrders);
            this.startActivityForResult(intent, THREE);
        }
    }

//    @SuppressLint("MissingSuperCall")
//    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        order = (Order) data.getSerializableExtra("myData3");

    }

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}