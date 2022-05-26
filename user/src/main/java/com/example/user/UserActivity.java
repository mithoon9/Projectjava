package com.example.user;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    DBhelper db;
    EditText user, password;
    Button login, register;
    private String name, passwords, spName, spPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        user = findViewById(R.id.edittext);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.reg);
        db = new DBhelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validUserData()) {
                    if (db.getdata(user.getText().toString(),password.getText().toString()))
                    {
                        Intent intent = new Intent(UserActivity.this, DashBoard.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Unable to Login Plz Register !!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to Login Plz Enter Valid Data !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean validUserData() {
        name = user.getText().toString().trim();
        passwords = password.getText().toString().trim();
        return !(name.isEmpty() || passwords.isEmpty());
    }
}








