package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Objects;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        ImageView imageView = findViewById(R.id.locationImage);
        Intent intent = getIntent();
        String location = intent.getStringExtra("LOCATION");
        if(location.equals("PARIS")){
            imageView.setBackgroundResource(R.drawable.paris);
        }else  if(location.equals("MEXICO")){
            imageView.setBackgroundResource(R.drawable.mexico);
        }else  if(location.equals("EGYPT")){
            imageView.setBackgroundResource(R.drawable.egypt);
        }
    }
}