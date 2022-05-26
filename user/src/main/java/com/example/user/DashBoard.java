package com.example.user;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {
private CardView first, second, third, fourth, fifth, six;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        first= (CardView)findViewById(R.id.first);
        second=(CardView)findViewById(R.id.second);
        third=(CardView)findViewById(R.id.third);
        fourth=(CardView)findViewById(R.id.fourth);
        fifth=(CardView)findViewById(R.id.fifth);
        six=(CardView)findViewById(R.id.six);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(DashBoard.this, Profile.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Sucess",Toast.LENGTH_LONG ).show();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(DashBoard.this, HealthService.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Sucess",Toast.LENGTH_LONG ).show();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(DashBoard.this, HealthTips.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Sucess",Toast.LENGTH_LONG ).show();
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(DashBoard.this, Vaccine.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Sucess",Toast.LENGTH_LONG ).show();
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(DashBoard.this, Pgwomen.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Sucess",Toast.LENGTH_LONG ).show();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(DashBoard.this, Hospital.class);
                startActivity(i);
                Toast.makeText(DashBoard.this, "Sucess",Toast.LENGTH_LONG ).show();
            }
        });

    }



    @Override
    public void onClick(View v) {

    }
}
