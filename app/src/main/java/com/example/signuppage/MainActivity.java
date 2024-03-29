package com.example.signuppage;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    Animation uptodown, downtoup;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //setContentView(R.layout.activity_home);
        setContentView(R.layout.activity_welcome_screen);
        button = (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        textView = (TextView)findViewById(R.id.textView);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        textView.setAnimation(uptodown);
        button.setAnimation(downtoup);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.rfamb);
        mediaPlayer.start();
    }
}