package com.example.signuppage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity
{
    EditText input_username, input_password;
    FloatingActionButton clk;
    firebase firebase;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        input_username = (EditText) findViewById(R.id.username);
        input_password = (EditText) findViewById(R.id.password);
        clk = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        firebase = new firebase();
        TextView textView = findViewById(R.id.new_user);
        String text = "New Here? Sign Up Now";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Login.this, "Sign up", Toast.LENGTH_SHORT);

                Intent in = new Intent(Login.this,SignUp.class);
                startActivity(in);
            }
            @Override
            public void updateDrawState(TextPaint ds)
            {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
            }
        };
        ss.setSpan(clickableSpan, 10, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        clk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                String name = input_username.getText().toString();
                String password = input_password.getText().toString();
                validate();


            }
        });
    }
    public void validate(){
        ref = FirebaseDatabase.getInstance().getReference().child("users").child("1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String db_username = dataSnapshot.child("username").getValue().toString();
                String db_password = dataSnapshot.child("password").getValue().toString();

                //print_user.setText(username.getText().toString());
                //print_user.setText(db_username);
                Toast.makeText(Login.this, "okay", Toast.LENGTH_SHORT).show();

                if (db_username.equals(input_username.getText().toString()) && db_password.equals(input_password.getText().toString())){
                    Toast.makeText(Login.this, "Welcome, Soo Yong Jie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Login.this, "Login unsuccessful. Try again", Toast.LENGTH_SHORT).show();
                }


            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // do nothing
            }
        });
    }
}
