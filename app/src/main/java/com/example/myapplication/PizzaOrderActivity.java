package com.example.myapplication;
/**
 * This class is the UI that contains the run function to interract with album collections

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This class controls the gui for ordering the different types of pizza
 */
public class PizzaOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUESTCODE = 1;
    private DecimalFormat df;
    private ImageView pizza;
    private TextView price;
    private Order order;
    private Pizza initialSmallPizza;
    private Spinner size;
    private ChipGroup toppingGroup;
    private Chip pepperoni, pineapple, olives, ham, chicken, mushroom, onion;
    private String number;

    /**
     * On start up of the page it turns on toppings that go with the type of pizza
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_order);
        setTitle("Pizza Order");
        Intent intent = getIntent();
        String pizzaType = intent.getStringExtra("PIZZA");
        number = intent.getStringExtra("NUMBER");
        order = (Order) getIntent().getSerializableExtra("Order");
        System.out.println(order.getPhoneNum());
        extra();
        if(pizzaType.equals("deluxe")){
            pizza.setImageResource(R.drawable.delpizza);
            olives.setChecked(true);
            chicken.setChecked(true);
            mushroom.setChecked(true);
            onion.setChecked(true);
            pepperoni.setChecked(true);
        } else if(pizzaType.equals("hawaiian")){
            pizza.setImageResource(R.drawable.hawaiianhampizza);
            ham.setChecked(true);
            pineapple.setChecked(true);
        } else if(pizzaType.equals("pepperoni")){
            pizza.setImageResource(R.drawable.pepperonipizza);
            pepperoni.setChecked(true);
        }
        initialSmallPizza = PizzaMaker.createPizza(pizzaType);
        price = findViewById(R.id.pizzaOrderPrice);
        price.setText(String.valueOf(initialSmallPizza.getprice()));
        ArrayList<String> sizes= new ArrayList<>();
        sizes.add("Small");
        sizes.add("Medium");
        sizes.add("Large");
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Size, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(arrayAdapter);
    }

    /**
     * Contains initialization of other variables needed throughout the program
     */
    public void extra (){
        df = new DecimalFormat("#.##");
        pizza = findViewById(R.id.pizza);
        size = findViewById(R.id.sizes);
        toppingGroup = findViewById(R.id.toppingGroup);
        pepperoni = findViewById(R.id.pepperoni);
        pineapple = findViewById(R.id.pineapple);
        olives = findViewById(R.id.olives);
        ham = findViewById(R.id.ham);
        chicken = findViewById(R.id.chicken);
        mushroom = findViewById(R.id.mushroom);
        onion = findViewById(R.id.onion);
        size.setOnItemSelectedListener(this);
    }

    /**
     * Allows person to change the alotted toppings
     * @param view
     */
    public void toppingClick(View view){
        ArrayList<Topping> tops = new ArrayList<>();
        List<Integer> selectedTopIds = toppingGroup.getCheckedChipIds();
        for(Integer id: selectedTopIds){
            switch (id){
                case R.id.chicken:
                    tops.add(Topping.CHICKEN);
                    break;
                case R.id.olives:
                    tops.add(Topping.OLIVES);
                    break;
                case R.id.onion:
                    tops.add(Topping.ONION);
                    break;
                case R.id.pepperoni:
                    tops.add(Topping.PEPPERONI);
                    break;
                case R.id.pineapple:
                    tops.add(Topping.PINEAPPLE);
                    break;
                case R.id.ham:
                    tops.add(Topping.HAM);
                    break;
                case R.id.mushroom:
                    tops.add(Topping.MUSHROOM);
                    break;
            }
        }
        initialSmallPizza.setToppings(tops);
        price.setText((CharSequence) df.format(initialSmallPizza.getprice()));
    }

    /**
     * Adss the pizza to the current order
     * @param view
     */
    public void onAddToOrderClick(View view){
        order.addPizza(initialSmallPizza,initialSmallPizza.getprice());
        Intent data = new Intent();
        data.putExtra("order", order);
        setResult(RESULT_OK, data);
        finish();
//        order.addPizza(initialSmallPizza,initialSmallPizza.getprice());
//        Intent data = new Intent();
//        Bundle b = data.getExtras();
//        b.putSerializable("order", order);
//        data.putExtras(b);
//        setResult(RESULT_OK, data);
//        finish();
    }

    /**
     * Allows user to change the size of the pizza
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        initialSmallPizza.changeSize(text);
        initialSmallPizza.getprice();
        price.setText((CharSequence) df.format(initialSmallPizza.getprice()));
    }

    /**
     * what to do when user is not interacting with the gui
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
