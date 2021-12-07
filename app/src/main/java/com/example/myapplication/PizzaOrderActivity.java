package com.example.myapplication;

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

public class PizzaOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    private ObservableList<String> selectTopping = FXCollections.observableArrayList ();
//    private ObservableList<String> additionalTopping = FXCollections.observableArrayList ();

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
        price.setText(String.valueOf(initialSmallPizza.getprice()));
    }

    public void onAddToOrderClick(View view){
        order.addPizza(initialSmallPizza,initialSmallPizza.getprice());

//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        intent.putExtra("Order", order);
//        intent.putExtra("Number", number);
//        intent.putExtra("RequestCode", REQUESTCODE);
////        setResult(RESULT_OK, intent);
//        startActivity(intent);
//        Intent data = new Intent(this, MainActivity.class);
//        data.putExtra("num",order.getPhoneNum());
//        data.putExtra("Order",order);
//        System.out.println(order.getPrice());
//        setResult(RESULT_OK, data);
        Intent data = new Intent();
        data.putExtra("myData1", order.getPhoneNum());
        data.putExtra("myData3", order);
        data.putExtra("myData2", "Data 2 value");
// Activity finished ok, return the data
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        initialSmallPizza.changeSize(text);
        initialSmallPizza.getprice();
        price.setText((CharSequence) String.valueOf(initialSmallPizza.getprice()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
