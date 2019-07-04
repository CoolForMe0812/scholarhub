package com.example.signuppage;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class Message extends AppCompatActivity {

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_message, mobileArray);

        ListView listView = (ListView) findViewById(R.id.messageList);
        listView.setAdapter(adapter);
    }
}