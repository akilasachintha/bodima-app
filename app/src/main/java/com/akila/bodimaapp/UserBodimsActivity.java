package com.akila.bodimaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserBodimsActivity extends AppCompatActivity {

    private EditText mName, mPhone, mAddress, mBeds;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bodims);

        mName = findViewById(R.id.edit_name);
        mPhone = findViewById(R.id.edit_phone);
        mAddress = findViewById(R.id.edit_address);
        mBeds = findViewById(R.id.edit_beds);

        Button mAddBtn = findViewById(R.id.add_btn);
        Button mViewBtn = findViewById(R.id.view_btn);

        mAddBtn.setOnClickListener(v -> {
            String name = mName.getText().toString();
            String phone = mPhone.getText().toString();
            String address = mAddress.getText().toString();
            String beds = mBeds.getText().toString();

            HashMap<String, String> userMap = new HashMap<>();
            userMap.put("name", name);
            userMap.put("phone", phone);
            userMap.put("address", address);
            userMap.put("beds", beds);

            root.push().setValue(userMap)
                    .addOnSuccessListener(unused -> Toast.makeText(UserBodimsActivity.this, "Data added Successfully", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(UserBodimsActivity.this, "Database Error or Check Data", Toast.LENGTH_SHORT).show());
        });

        mViewBtn.setOnClickListener(v -> startActivity(new Intent(UserBodimsActivity.this, ShowUserListActivity.class)));

    }
}