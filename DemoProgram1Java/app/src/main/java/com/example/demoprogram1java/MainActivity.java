package com.example.demoprogram1java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int textClicked;
    private int buttonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clicked(View v){
        switch (v.getId()) {
            case (R.id.buttonChangeText) :
                textClicked++;
                Button b = findViewById(R.id.buttonClickMe);
                b.setText("I was Clicked " + textClicked + " times");
                break;

            case (R.id.buttonClickMe) :
                buttonClicked++;
                TextView t = findViewById(R.id.textViewCounter);
                t.setText(String.valueOf(buttonClicked));
                break;
            default:
                break;
        }
    }
}