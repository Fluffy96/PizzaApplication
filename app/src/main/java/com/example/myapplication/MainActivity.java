package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

    private TextView phoneNumber;
    private ImageView deluxePizza, hawaiianPizza, pepperoniPizza, cOrder, sOrder;
    private Order order = new Order();
    private StoreOrders storeOrders = new StoreOrders();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        order = (Order) intent.getSerializableExtra("Order");
        phoneNumber = findViewById(R.id.phoneNumber);
    }

    public void onDeluxeClick(View view){
        Intent intent = new Intent(getApplicationContext(), PizzaOrderActivity.class);
        String pizzaType = "deluxe";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            order = new Order(phoneNumber.getText().toString());
            intent.putExtra("Order", order);
            this.startActivity(intent);
        }
    }

    public void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            order = new Order(phoneNumber.getText().toString());
            intent.putExtra("Order", order);
            this.startActivity(intent);
        }
    }

    public void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            order = new Order(phoneNumber.getText().toString());
            intent.putExtra("Order", order);
            this.startActivity(intent);
        }
    }

    public void onCOrderClick(View view){
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        intent.putExtra("NUMBER", phoneNumber.getText());
        if(numberChecker(phoneNumber)) {
            intent.putExtra("Order", order);
            intent.putExtra("StoreOrders", storeOrders);
            this.startActivity(intent);
        }
    }

    public void onSOrderClick(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        intent.putExtra("NUMBER", phoneNumber.getText()); //might not need
        if(numberChecker(phoneNumber)) {
            intent.putExtra("StoreOrders", storeOrders);
            this.startActivity(intent);
        }
    }

    public boolean numberChecker(TextView t){
        String num = t.getText().toString();
        if(num.length() == 10){
            //Toast.makeText(getApplicationContext(),"Correct Length",Toast.LENGTH_SHORT).show();
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