package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaOrder extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageView pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_order);
        Intent intent = getIntent();
        String pizzaType = intent.getStringExtra("PIZZA");
        pizza = findViewById(R.id.pizza);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
