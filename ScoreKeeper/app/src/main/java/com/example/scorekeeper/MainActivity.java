package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView team1;
    private TextView team2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1 = findViewById(R.id.textViewTeam1Counter);
        team2 = findViewById(R.id.textViewTeam2Counter);

        Button team1Minus = findViewById(R.id.buttonTeam1Minus);
        Button team1Plus = findViewById(R.id.buttonTeam1Plus);
        Button team2Minus = findViewById(R.id.buttonTeam2Minus);
        Button team2Plus = findViewById(R.id.buttonTeam2Plus);

        team1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView team1 = findViewById(R.id.textViewTeam1Counter);
                int value = Integer.parseInt(team1.getText().toString());
                if (value >= 50)
                    team1.setText(String.valueOf(value - 50));
            }
        });

        team1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TextView team1 = findViewById(R.id.textViewTeam1Counter);
                int value = Integer.parseInt(team1.getText().toString());
                team1.setText(String.valueOf(value + 50));
            }
        });

        team2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(team2.getText().toString());
                if (value >= 50)
                    team2.setText(String.valueOf(value - 50));
            }
        });

        team2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(team2.getText().toString());
                team2.setText(String.valueOf(value + 50));
            }
        });
    }

    public void onClick(View v) {
//        switch(v.getId()) {
//            case (R.id.buttonTeam1Minus): {
//                Integer value = Integer.parseInt(team1.getText().toString());
//                if (value >= 50)
//                    team1.setText(String.valueOf(value - 50));
//                break;
//            }
//            case (R.id.buttonTeam1Plus): {
//                Integer value = Integer.parseInt(team1.getText().toString());
//                team1.setText(String.valueOf(value + 50));
//                break;
//            }
//            case (R.id.buttonTeam2Minus): {
//                Integer value = Integer.parseInt(team2.getText().toString());
//                if (value >= 50)
//                    team2.setText(String.valueOf(value - 50));
//                break;
//            }
//            case (R.id.buttonTeam2Plus): {
//                Integer value = Integer.parseInt(team2.getText().toString());
//                team2.setText(String.valueOf(value + 50));
//                break;
//            }
//            default:
//                break;
//        }
    }
}