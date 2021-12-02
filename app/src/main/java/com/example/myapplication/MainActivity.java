package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView phoneNumber;
    private ImageView deluxePizza, hawaiianPizza, pepperoniPizza, cOrder, sOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = findViewById(R.id.phoneNumber);
    }

    protected void onDeluxeClick(View view){
        Intent intent = new Intent(this, PizzaOrder.class);
        String pizzaType = "deluxe";
        intent.putExtra("PIZZA", pizzaType);
        startActivity(intent);
    }

    protected void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaOrder.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        startActivity(intent);
    }

    protected void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaOrder.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}