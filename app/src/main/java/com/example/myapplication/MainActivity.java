package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        intent.putExtra("NUMBER", phoneNumber.toString());
        if(numberChecker(phoneNumber))
            this.startActivity(intent);
    }

    public void onHawaiianClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "hawaiian";
        intent.putExtra("PIZZA", pizzaType);
        if(numberChecker(phoneNumber))
            this.startActivity(intent);
    }

    public void onPepperoniClick(View view){
        Intent intent = new Intent(this, PizzaOrderActivity.class);
        String pizzaType = "pepperoni";
        intent.putExtra("PIZZA", pizzaType);
        if(numberChecker(phoneNumber))
            this.startActivity(intent);
    }

    public void onCOrderClick(View view){
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        if(numberChecker(phoneNumber))
            this.startActivity(intent);
    }

    public void onSOrderClick(View view){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        if(numberChecker(phoneNumber))
            this.startActivity(intent);
    }

    public boolean numberChecker(TextView t){
        String num = t.toString();
        if(num.length() == 10){
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