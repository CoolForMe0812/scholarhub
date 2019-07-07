package com.example.signuppage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    TextView faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        faq = (TextView) findViewById(R.id.faq);

        faq.setOnClickListener(new View.OnClickListener()
        {
            @Override
                public void onClick(View view)
                {
                Intent intent = new Intent(Profile.this, FAQ.class);
                startActivity(intent);
            }
        });

    }
}