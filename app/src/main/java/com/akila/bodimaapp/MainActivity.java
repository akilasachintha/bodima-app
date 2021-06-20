package com.akila.bodimaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<BodimModel> mList;
    private UserBodimAdapter mAdapter;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mLoginBtn = findViewById(R.id.main_login_btn);
        Button mRegisterBtn = findViewById(R.id.main_register_btn);

        RecyclerView userBodimRecyclerView = findViewById(R.id.recycler_view);
        userBodimRecyclerView.setHasFixedSize(true);
        userBodimRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();
        mAdapter = new UserBodimAdapter(this, mList);

        userBodimRecyclerView.setAdapter(mAdapter);


        mLoginBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        mRegisterBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, RegisterActivity.class)));

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    BodimModel model = dataSnapshot.getValue(BodimModel.class);
                    mList.add(model);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}