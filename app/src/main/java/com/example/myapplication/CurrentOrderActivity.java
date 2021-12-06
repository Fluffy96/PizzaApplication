package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class CurrentOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private DecimalFormat df = new DecimalFormat("#.##");
    private Order order = new Order();
    private TextView subtotal, salesTax, ordertotal, phoneNumberOrder;
    private ListView currOrderListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_order);
        setTitle("Current Order");
        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        ordertotal = findViewById(R.id.ordertotal);
        phoneNumberOrder = findViewById(R.id.phoneNumberOrder);
        currOrderListView = findViewById(R.id.currOrderListView);
        Intent intent = getIntent();
        CharSequence number = intent.getStringExtra("NUMBER");
        phoneNumberOrder.setText(number);
    }

    public void onRemovePizzaClick(View view){

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
