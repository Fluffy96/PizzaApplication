package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageView pizza;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_order);
        Intent intent = getIntent();
        String pizzaType = intent.getStringExtra("PIZZA");
        pizza = findViewById(R.id.pizza);
        if(pizzaType.equals("deluxe")){
            pizza.setImageResource(R.drawable.delpizza);
        } else if(pizzaType.equals("hawaiian")){
            pizza.setImageResource(R.drawable.hawaiianhampizza);
        } else if(pizzaType.equals("pepperoni")){
            pizza.setImageResource(R.drawable.pepperonipizza);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
