package com.akila.bodimaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button mRegisterBtn = findViewById(R.id.register_btn);
        TextView mAlreadyRegisteredBtn = findViewById(R.id.already_registered_btn);

        mRegisterBtn.setOnClickListener(v -> {
            Intent fp= new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(fp);
            Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
        });

        mAlreadyRegisteredBtn.setOnClickListener(v -> {
            Intent fp= new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(fp);
        });
    }
}