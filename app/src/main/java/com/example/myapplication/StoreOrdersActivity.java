package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StoreOrdersActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner numbers;
    private ListView sOrderListView;
    private TextView orderTotal;
    private Button cancelOrder;
    private String numberClicked;
    private StoreOrders storeOrders;
    private ArrayList<Order> order;
    private ArrayList<String> numList;
    private ArrayList<Double> cost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        numbers = findViewById(R.id.phoneNumbers);
        sOrderListView = findViewById(R.id.sOrderListView);
        orderTotal = findViewById(R.id.orderTotal);
        cancelOrder = findViewById(R.id.button3)    ;
        numList = storeOrders.getPhoneNumberList();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, numList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numbers.setAdapter(arrayAdapter);
    }

    public void onCancelOrder(View view){
        sOrderListView.getOnItemSelectedListener();
        storeOrders.removeOrder(numberClicked);
        numList = storeOrders.getPhoneNumberList();
        order = storeOrders.getOrders();
        cost = storeOrders.getTotalPrices();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
