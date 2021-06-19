package com.pabasara.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onBtnClick (View view) {
        TextView printFirstName = findViewById(R.id.printFirstName);
        TextView printLastName = findViewById(R.id.printLastName);
        TextView printEmail = findViewById(R.id.printEmail);
        EditText edtFirstName = findViewById(R.id.editFirstName);
        EditText edtLastName = findViewById(R.id.editLastName);
        EditText edtEmail = findViewById(R.id.editEmail);


        printFirstName.setText ("First Name " + edtFirstName.getText().toString());
        printLastName.setText ("Last Name " + edtLastName.getText().toString());
        printEmail.setText ("Email " + edtEmail.getText().toString());
    }
}