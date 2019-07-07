package com.example.signuppage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    TextView faq;
    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        faq = (TextView) findViewById(R.id.faq);
        signout = (Button) findViewById(R.id.signout);

        faq.setOnClickListener(new View.OnClickListener()
        {
            @Override
                public void onClick(View view)
                {
                Intent intent = new Intent(Profile.this, FAQ.class);
                startActivity(intent);
            }
        });

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, Login.class);
                startActivity(intent);
            }
        });

        // Navigation intent
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent h = new Intent(Profile.this, Home.class);
                        startActivity(h);
                        break;
                    case R.id.interests:
                        Intent i = new Intent(Profile.this, Interest.class);
                        startActivity(i);
                        break;
                    case R.id.profile:
                        Intent p = new Intent(Profile.this, Profile.class);
                        startActivity(p);
                        break;
                }
                return false;
            }
        });

    }
}