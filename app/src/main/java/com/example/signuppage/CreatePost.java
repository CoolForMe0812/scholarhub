package com.example.signuppage;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreatePost extends AppCompatActivity
{
   FloatingActionButton floatingActionButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);
        floatingActionButton1 = findViewById(R.id.floatingActionButton1);

        floatingActionButton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CreatePost.this, PostDetails.class);
                startActivity(intent);
            }
        });
    }
}

