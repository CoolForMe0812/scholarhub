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

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Post extends AppCompatActivity
{
    EditText Text1, editText3;
    FloatingActionButton clk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Text1 = (EditText) findViewById(R.id.Text1);
        editText3 = (EditText) findViewById(R.id.editText3);
        clk = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        TextView textView = findViewById(R.id.new_user);
        String text = "New Here? Sign Up Now";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Post.this, "Sign up", Toast.LENGTH_SHORT);

                Intent in = new Intent(Post.this,MainActivity.class);
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
                String stText1 = Text1.getText().toString();
                String steditText3 = editText3.getText().toString();

                if (stText1.equals("Gavin") && steditText3.equals("gavin0701")) {
                    Intent in = new Intent(Post.this, Home.class);
                    startActivity(in);
                } else if (stText1.equals("") || steditText3.equals("")) {
                    Toast.makeText(getBaseContext(), "Enter both Name and Password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Wrong Name or Password entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
