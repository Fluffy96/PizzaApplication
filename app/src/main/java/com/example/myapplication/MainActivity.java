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
    private Order order;
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
            if(order == null || order.getPhoneNum().equals(phoneNumber.getText())) {
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
            if(order == null || order.getPhoneNum().equals(phoneNumber.getText())) {
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
            if(order == null || order.getPhoneNum().equals(phoneNumber.getText())) {
                order = new Order(phoneNumber.getText().toString());
            }
            intent.putExtra("Order", order);
            this.startActivityForResult(intent, ONE);
        }
    }

    public void onCOrderClick(View view){
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            intent.putExtra("NUMBER", order.getPhoneNum());
            intent.putExtra("Order", order);
            intent.putExtra("StoreOrders", storeOrders);
            this.startActivityForResult(intent, TWO);
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
//        super.onActivityResult(requestCode, resultCode, intent);
//        //int requestCode = ONE;//intent.getIntExtra("RequestCode", ONE);
//        //super.onActivityResult(requestCode, resultCode, intent);
//        if (requestCode == ONE) {
//            Bundle b = getIntent().getExtras();
//            order = (Order) intent.getSerializableExtra("Order");
//            if (order == null) {
//                Toast.makeText(getApplicationContext(),"NULL",Toast.LENGTH_SHORT).show();
//            }
//        }
//        if (requestCode == TWO) {
//            order = (Order) intent.getSerializableExtra("Order");
//            storeOrders = (StoreOrders) intent.getSerializableExtra("StoreOrders");
//            currentOrderTotal = intent.getDoubleExtra("currentOrderTotal", NEG);
//            //currentNumber = intent.getStringExtra("number");
//            storeOrders.addOrders(order);
//            storeOrders.addTP(currentOrderTotal);
//            storeOrders.addPhoneNumbers(currentNumber);
//        }
//        if (requestCode == THREE) {
//            //NEED TO MOD
//            storeOrders = (StoreOrders) intent.getSerializableExtra("StoreOrders");
//        }
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println(order.getPizzaList().toString());
        System.out.println("maybe");
        System.out.println(data.getStringExtra("myData1"));
        Order newOrder = (Order) data.getSerializableExtra("myData3");
        order= newOrder;
        System.out.println(order.getPizzaList().toString());
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("myData1")) {
                System.out.println(data.getStringExtra("myData1"));
            }
        }
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