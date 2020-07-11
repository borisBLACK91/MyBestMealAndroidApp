package com.borisblack.mybestmealrestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private ImageView backImage;
    AnimationDrawable homeAnimation;
    private Button bookNowButton;
    private Button discoverMenuButton;
    private Button ourAddressButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookNowButton = findViewById(R.id.bookNowButton);
        bookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBookActivity();
            }
        });

        discoverMenuButton = findViewById(R.id.discoverButton);
        discoverMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDiscoverMenuActivity();
            }
        });


        ourAddressButton = findViewById(R.id.ourAddressButton);
        ourAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callOurAddressActivity();
            }
        });

        backImage = findViewById(R.id.homeTransition);
        backImage.setBackgroundResource(R.drawable.home_background_anim);
        homeAnimation = (AnimationDrawable) backImage.getBackground();
        homeAnimation.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.bookMenuButton){
            callBookActivity();
        }
        if(id == R.id.discoverMenuMenuButton){
            callDiscoverMenuActivity();
        }
        if(id == R.id.ourAddressMenuButton){
            callOurAddressActivity();
        }
        return true;
    }

    private void callBookActivity(){
        Intent intent = new Intent(this, BookNowActivity.class);
        startActivity(intent);
    }

    private void callDiscoverMenuActivity(){
        Intent intent = new Intent(this, RestaurantMenuActivity.class);
        startActivity(intent);
    }

    private void callOurAddressActivity(){
        Intent intent = new Intent(this, OurAdressActivity.class);
        startActivity(intent);
    }

}