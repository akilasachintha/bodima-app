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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ShowUserListActivity extends AppCompatActivity {

    private UserBodimAdapter adapter;
    private ArrayList<BodimModel> list;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_list);

        RecyclerView userBodimRecyclerView = findViewById(R.id.user_recycler_view);
        userBodimRecyclerView.setHasFixedSize(true);
        userBodimRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button mAddBodimBtm = findViewById(R.id.add_bodim_btn);

        list = new ArrayList<>();

        adapter = new UserBodimAdapter(this, list);
        userBodimRecyclerView.setAdapter(adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    BodimModel model = dataSnapshot.getValue(BodimModel.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        mAddBodimBtm.setOnClickListener(v -> startActivity(new Intent(ShowUserListActivity.this, UserBodimsActivity.class)));
    }
}