package com.example.user;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
Button btnAdd;
DBhelper db;
EditText name, address, email, password, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone1);
        address=findViewById(R.id.address);
        password=findViewById(R.id.password2);
        db= new DBhelper(this);

        btnAdd=findViewById(R.id.signup);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() && address.getText().toString().isEmpty()
                        && email.getText().toString().isEmpty() && password.getText().toString().isEmpty() && phone.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_LONG);
                } else {
                    Toast.makeText(RegisterActivity.this,"All fields found, adding to database",Toast.LENGTH_LONG);
                    boolean result = db.insertData(name.getText().toString(), address.getText().toString(), email.getText().toString(), password.getText().toString(), phone.getText().toString());

                    if (result) {
                        showMessage("Success", "Your data has been Register successfully");
                        Intent i = new Intent(RegisterActivity.this, UserActivity.class);
                        startActivity(i);
                    } else {
                        showMessage("Error", "Error inserting data");
                    }
                }
            }
        });
    }
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();
    }


}
