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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class controls what happens on the current order page
 */
public class CurrentOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final double NO_COST = 0;
    private DecimalFormat df = new DecimalFormat("#.##");
    private Order order;
    private StoreOrders storeOrders;
    private TextView subtotal, salesTax, ordertotal, phoneNumberOrder;
    private ListView currOrderListView;
    ArrayAdapter<String> pizzas;
    private String number;
    private int removePosition = -1;
    private static final double TAX = 0.06625;

    /**
     *  On start up of the page it populates list view of the currently ordered pizzas
     * @param savedInstanceState
     */
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
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listString);
            currOrderListView.setAdapter(adapter);
            subtotal.setText(df.format(order.getPrice()));
            salesTax.setText(df.format(order.getPrice() * TAX));
            ordertotal.setText(df.format(order.getPrice() + order.getPrice() * TAX));
            currOrderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String str = "Clicked on "+ listString.get(position) +" if you press remove it will be removed";
                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                    removePosition = position;
                }
            });
        }
    }

    /**
     * Method used to remove pizzas from the array list
     * @param view
     */
    public void onRemovePizzaClick(View view){
        int index = currOrderListView.getCheckedItemPosition();

        if(removePosition==-1){
            Toast.makeText(getApplicationContext(), "Have not clicked on anything to remove", Toast.LENGTH_SHORT).show();
        }else{
            order.removePizza(order.getPizzaList().get(removePosition));
            Intent data = new Intent();
            data.putExtra("myData3", order);
            setResult(RESULT_OK, data);
            ArrayList<Pizza> list  = order.getPizzaList();
            ArrayList<String> listString = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                listString.add(list.get(i).toString());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listString);
            currOrderListView.setAdapter(adapter);
            double cost = NO_COST;
            //ArrayList<Pizza> list  = order.getPizzaList();
            for(int i =0; i< list.size(); i++){
                //currOrders.add(list.get(i).toString());
                cost = cost + list.get(i).getprice();
            }
            subtotal.setText(df.format(cost));
            System.out.println(df.format(cost));
            salesTax.setText(df.format(cost * TAX));
            ordertotal.setText(df.format(cost + cost * TAX));
        }


    }

    /**
     * Method is used to add the order to the store order
     * @param view
     */
    public void onPlaceOrder(View view){
        if(storeOrders.isIn(number) == false) {
            storeOrders.addOrders(order);
            Intent data = new Intent();
            Bundle b = data.getExtras();
            b.putSerializable("order", order);
            b.putSerializable("storeOrders", storeOrders);
            data.putExtras(b);
            setResult(RESULT_OK, data);
            finish();
        }
    }

    /**
     * Method id for the listview and if soemthing is clicked in said list
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * What to do if user is not interacting with the gui
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
