package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView phoneNumber;
    private ImageView deluxePizza, hawaiianPizza, pepperoniPizza, cOrder, sOrder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.phoneNumber);
    }

    public void onDeluxeClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "deluxe";
        intent.putExtra("PIZZA", pizzaType);
        this.startActivity(intent);
    }

    public void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        this.startActivity(intent);
    }

    public void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        this.startActivity(intent);
    }

    public void onCOrderClick(View view){
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        this.startActivity(intent);
    }

    public void onSOrderClick(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}