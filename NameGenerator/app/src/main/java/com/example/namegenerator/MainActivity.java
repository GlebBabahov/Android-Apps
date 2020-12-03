package com.example.namegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int TIME_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Names.class);
                startActivity(intent);
                finish();
            }
        }, TIME_DELAY);
    }

//    public void changeIntentClick(View v) {
//        Intent intent  = new Intent(this, Splash.class);
//        startActivity(intent);
//    }
}