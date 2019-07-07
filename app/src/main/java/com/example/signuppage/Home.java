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

    // Menu button intent
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.home) {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this, Home.class);
            this.startActivity(intent);
            return true;
        }

        if (id == R.id.interests) {
            Toast.makeText(this, "interests", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home.this, Interest.class);
            this.startActivity(intent);
            return true;
        }

        if (id == R.id.profile) {
            Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Home .this, Profile.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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

        // Navigation intent
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent h = new Intent(Home.this, Home.class);
                        startActivity(h);
                        Toast.makeText(Home.this, "HOME", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.interests:
                        Intent i = new Intent(Home.this, Interest.class);
                        startActivity(i);
                        Toast.makeText(Home.this, "INTEREST", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profile:
                        Intent p = new Intent(Home.this, Profile.class);
                        startActivity(p);
                        Toast.makeText(Home.this, "PROFILE", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
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


        
    }
}