package com.example.dell.carehealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    private CardView first, second, third, fourth, fifth, six;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        first = (CardView) findViewById(R.id.first);
        second = (CardView) findViewById(R.id.second);
        third = (CardView) findViewById(R.id.third);
        fourth = (CardView) findViewById(R.id.fourth);
        fifth = (CardView) findViewById(R.id.fifth);
        six = (CardView) findViewById(R.id.six);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Dashboard.this, AdminActivity.class);
                startActivity(i);
                Toast.makeText(Dashboard.this, "Sucess", Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public void onClick(View v) {

    }
}


