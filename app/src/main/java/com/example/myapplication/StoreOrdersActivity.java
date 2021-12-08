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
import android.widget.Toast;

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
        storeOrders = (StoreOrders) intent.getSerializableExtra("storeOrders");
        if(storeOrders!=null) {
            numList = storeOrders.getPhoneNumberList();
            Toast.makeText(getApplicationContext(),(numList.isEmpty())?"NumList Empty":numList.get(0),Toast.LENGTH_SHORT).show();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            numbers.setAdapter(arrayAdapter);
        }
        else {
            Toast.makeText(getApplicationContext(),"NULL",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Allows user to cancel an order that was created
     * @param view
     */
    public void onCancelOrder(View view){
        if(numberClicked!=null) {
            sOrderListView.getOnItemSelectedListener();
            storeOrders.removeOrder(numberClicked);
            numList = storeOrders.getPhoneNumberList();
            order = storeOrders.getOrders();
            cost = storeOrders.getTotalPrices();
        }
        Intent i = new Intent();
        i.putExtra("storeOrders", storeOrders);
        setResult(RESULT_OK, i);
        finish();
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
        numberClicked = parent.getItemAtPosition(position).toString();
        ArrayList<Order> order = storeOrders.getOrders();
        Order o = order.get(position);
        ArrayList<Pizza> p = o.getPizzaList();
        ArrayList<String> pString = new ArrayList<String>();
        for (int i = 0; i < p.size(); i++) {
            pString.add(p.get(i).toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pString);
        sOrderListView.setAdapter(adapter);
        orderTotal.setText(o.toString());
    }

    /**
     * How the gui reacts when there is zero user input
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
