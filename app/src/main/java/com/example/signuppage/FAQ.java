package com.example.signuppage;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // Navigation intent
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent h = new Intent(FAQ.this, Home.class);
                        startActivity(h);
                        break;
                    case R.id.interests:
                        Intent i = new Intent(FAQ.this, Interest.class);
                        startActivity(i);
                        break;
                    case R.id.profile:
                        Intent p = new Intent(FAQ.this, Profile.class);
                        startActivity(p);
                        break;
                }
                return false;
            }
        });
    }
}