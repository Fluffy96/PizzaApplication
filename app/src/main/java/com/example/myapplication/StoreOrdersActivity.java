package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
import android.content.Intent;
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

/**
 * This class handels the store order gui
 */
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

    /**
     * Thise method sets up the gui initially when it is first opened up too
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_orders);
        numbers = findViewById(R.id.phoneNumbers);
        sOrderListView = findViewById(R.id.sOrderListView);
        orderTotal = findViewById(R.id.orderTotal);
        cancelOrder = findViewById(R.id.button3)    ;
        Intent intent = getIntent();
        storeOrders = (StoreOrders) intent.getSerializableExtra("StoreOrders");
        if(storeOrders!=null) {
            numList = storeOrders.getPhoneNumberList();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            numbers.setAdapter(arrayAdapter);
        }
    }

    /**
     * Allwos user to cancel an order that was created
     * @param view
     */
    public void onCancelOrder(View view){
        sOrderListView.getOnItemSelectedListener();
        storeOrders.removeOrder(numberClicked);
        numList = storeOrders.getPhoneNumberList();
        order = storeOrders.getOrders();
        cost = storeOrders.getTotalPrices();
    }

    /**
     * Used to select users in the spinner structure
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * How the gui reacts when there is zero user input
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
