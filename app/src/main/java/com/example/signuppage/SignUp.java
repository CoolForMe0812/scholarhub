package com.example.signuppage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText input_username, input_password;
    FloatingActionButton floatingActionButton;
    firebase firebase;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        input_username = (EditText) findViewById(R.id.username);
        input_password = (EditText) findViewById(R.id.password);
        firebase = new firebase();
        ref = FirebaseDatabase.getInstance().getReference().child("users");


        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SignUp.this, "Data saved successfully, hopefully", Toast.LENGTH_SHORT).show();

                    firebase.setUsername(input_username.getText().toString().trim());
                    firebase.setPassword(input_password.getText().toString().trim());
                    ref.push().setValue(firebase);
                    Toast.makeText(SignUp.this, "Data saved successfully, hopefully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
