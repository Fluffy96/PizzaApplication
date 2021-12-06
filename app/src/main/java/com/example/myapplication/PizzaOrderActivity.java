package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;

public class PizzaOrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

//    private ObservableList<String> selectTopping = FXCollections.observableArrayList ();
//    private ObservableList<String> additionalTopping = FXCollections.observableArrayList ();

    private ImageView pizza;
    private TextView price;
    private Order order;
    private Pizza initialSmallPizza;
    private Spinner size;
    private ChipGroup toppingGroup;
    private Chip pepperoni, pineapple, olives, ham, chicken, mushroom, onion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_order);
        setTitle("@strings/potitle");
        Intent intent = getIntent();
        String pizzaType = intent.getStringExtra("PIZZA");
        String number = intent.getStringExtra("NUMBER");
        order = new Order(number);
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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizes);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        size.setAdapter(arrayAdapter);
    }

    public void extra (){
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
                    Toast.makeText(getApplicationContext(),"Clicked on Ham",Toast.LENGTH_SHORT).show();
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
    }

    public void onSizeSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
