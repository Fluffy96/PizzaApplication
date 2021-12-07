package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class CurrentOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private DecimalFormat df = new DecimalFormat("#.##");
    private Order order;
    private StoreOrders storeOrders;
    private TextView subtotal, salesTax, ordertotal, phoneNumberOrder;
    private ListView currOrderListView;
    ArrayAdapter<String> pizzas;
    private String number;
    private static final double TAX = 0.06625;

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
        order = (Order) intent.getSerializableExtra("Order");
        number = order.getPhoneNum();
        storeOrders = (StoreOrders) intent.getSerializableExtra("StoreOrders");
        //
        phoneNumberOrder.setText(order.getPhoneNum());
        if(order.getPizzaList()!=null) {
            ArrayList<Pizza> list  = order.getPizzaList();
            ArrayList<String> listString = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                listString.add(list.get(i).toString());
                //currOrderListView.addView(list.get(i).toString());
                //cost = cost + list.get(i).getprice();
            }
            ArrayAdapter arr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listString);
            currOrderListView.setAdapter(arr);
            subtotal.setText(df.format(order.getPrice()));
            salesTax.setText(df.format(order.getPrice() * TAX));
            ordertotal.setText(df.format(order.getPrice() + order.getPrice() * TAX));
        }
    }

    public void onRemovePizzaClick(View view){
        int index = currOrderListView.getCheckedItemPosition();
        Toast.makeText(getApplicationContext(), String.valueOf(index), Toast.LENGTH_SHORT).show();
    }

    public void onPlaceOrder(View view){


        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
