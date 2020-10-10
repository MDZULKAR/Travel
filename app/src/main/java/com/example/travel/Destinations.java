package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Destinations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations);
        Button egypt = findViewById(R.id.egyptButton);
        Button paris = findViewById(R.id.parisButton);
        Button mexico = findViewById(R.id.mexicoButton);
        egypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Destinations.this, Location.class);
                intent.putExtra("LOCATION","EGYPT");
                startActivity(intent);
            }
        });

        paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Destinations.this, Location.class);
                intent.putExtra("LOCATION","PARIS");
                startActivity(intent);
            }
        });

        mexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Destinations.this, Location.class);
                    intent.putExtra("LOCATION","MEXICO");
                startActivity(intent);
            }
        });
    }
}