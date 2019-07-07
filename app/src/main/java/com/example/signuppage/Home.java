package com.example.signuppage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity
{
    Button button;
    TextView postBy, item;
    firebase firebase;
    DatabaseReference ref;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        firebase = new firebase();
        postBy = (TextView) findViewById(R.id.postBy);
        item = (TextView) findViewById(R.id.item);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String btnTxt = button.getText().toString();
                if (btnTxt.equals("Interested"))
                {
                    button.setText("Not Interested");
                }
                else button.setText("Interested");
            }
        });

        ref = FirebaseDatabase.getInstance().getReference().child("posts").child("1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String db_item = dataSnapshot.child("item").getValue().toString();
                String db_postBy = dataSnapshot.child("postBy").getValue().toString();
                item.setText(db_item);
                postBy.setText(db_postBy);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // do nothing
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                    Intent intent = new Intent(Home.this, CreatePost.class);
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
                        Intent h = new Intent(Home.this, Home.class);
                        startActivity(h);
                        break;
                    case R.id.interests:
                        Intent i = new Intent(Home.this, Interest.class);
                        startActivity(i);
                        break;
                    case R.id.profile:
                        Intent p = new Intent(Home.this, Profile.class);
                        startActivity(p);
                        break;
                }
                return false;
            }
        });

    }
}