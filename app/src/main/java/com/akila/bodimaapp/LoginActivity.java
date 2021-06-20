package com.akila.bodimaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button mLoginBtn = findViewById(R.id.login_btn);
        TextView mNotRegisteredBtn = findViewById(R.id.not_registered_btn);

        mLoginBtn.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, ShowUserListActivity.class)));

        mNotRegisteredBtn.setOnClickListener(v -> {
            Intent fp= new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(fp);
        });

    }
}