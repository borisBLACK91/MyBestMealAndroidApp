package com.borisblack.mybestmealrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenuActivity extends AppCompatActivity {

    private RecyclerView menuList;
    private List<MenuItem> menuItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        menuList = findViewById(R.id.menuItemsList);
        menuList.setLayoutManager(new LinearLayoutManager(this));
        createMenuItems();
        menuList.setAdapter(new MyAdapter(menuItems));
    }


    private void createMenuItems(){ //this method will create objects MenuItem
        MenuItem menuItem = new MenuItem("French Beef stake", "EUR 25.00", R.drawable.image1);
        MenuItem menuItem2 = new MenuItem("Senegalese Mix", "EUR 35.00", R.drawable.image2);
        MenuItem menuItem3 = new MenuItem("Cote D'Azur Burger", "EUR 15.00", R.drawable.image3);
        MenuItem menuItem4 = new MenuItem("Vietnam Super Rice", "EUR 13.50", R.drawable.image4);
        MenuItem menuItem5 = new MenuItem("Italian Cotellete", "EUR 18.50", R.drawable.image5);
        MenuItem menuItem6 = new MenuItem("Fat sandwich", "EUR 11.50", R.drawable.image6);
        MenuItem menuItem7 = new MenuItem("Super French Mixture", "EUR 22.50", R.drawable.image7);
        MenuItem menuItem8 = new MenuItem("The Cameroonian Smart Drink", "EUR 14.55", R.drawable.image8);
        MenuItem menuItem9 = new MenuItem("The french Saucisses", "EUR 14.50", R.drawable.image9);
        MenuItem menuItem10 = new MenuItem("The mixture of pleasure", "EUR 13.50", R.drawable.image10);
        menuItems.add(menuItem);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        menuItems.add(menuItem4);
        menuItems.add(menuItem5);
        menuItems.add(menuItem6);
        menuItems.add(menuItem7);
        menuItems.add(menuItem8);
        menuItems.add(menuItem9);
        menuItems.add(menuItem10);
    }

}