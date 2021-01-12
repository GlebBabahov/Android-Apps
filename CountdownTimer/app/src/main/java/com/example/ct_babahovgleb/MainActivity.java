package com.example.ct_babahovgleb;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int minutes = 0;
    private int seconds = 0;
//    private int totalSeconds = 0;
    private boolean colonIsVisible = false;
    private boolean isCounting = false;

    private TextView minutesView;
    private TextView secondsView;
    private TextView colonView;
    private ImageButton minutesButtonUp;
    private ImageButton minutesButtonDown;
    private ImageButton secondsButtonUp;
    private ImageButton secondsButtonDown;
    private ImageView alarmImage;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minutesView = findViewById(R.id.textViewMinutes);
        secondsView = findViewById(R.id.textViewSeconds);
        colonView = findViewById(R.id.textViewColon);
        minutesButtonUp = findViewById(R.id.imageButtonMinutesUp);
        minutesButtonDown = findViewById(R.id.imageButtonMinutesDown);
        secondsButtonUp = findViewById(R.id.imageButtonSecondsUp);
        secondsButtonDown = findViewById(R.id.imageButtonSecondsDown);
        startButton = findViewById(R.id.buttonStart);
        alarmImage = findViewById(R.id.imageViewAlarm);
        alarmImage.setVisibility(View.INVISIBLE);

        minutesView.setText(String.format(Locale.US, "%02d", minutes));
        secondsView.setText(String.format(Locale.US, "%02d", seconds));

        minutesButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isCounting) {
                    if (minutes >= 0 && minutes < 59) {
                        minutes++;
                    } else {
                        minutes = 0;
                    }
                    minutesView.setText(String.format(Locale.US, "%02d", minutes));
                }
            }
        });

        minutesButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isCounting) {
                    if (minutes > 0 && minutes <= 59) {
                        minutes--;
                    } else {
                        minutes = 59;
                    }
                    minutesView.setText(String.format(Locale.US, "%02d", minutes));
                }
            }
        });

        secondsButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isCounting) {
                    if (seconds >= 0 && seconds < 59) {
                        seconds++;
                    } else {
                        seconds = 0;
                    }
                    secondsView.setText(String.format(Locale.US, "%02d", seconds));
                }
            }
        });

        secondsButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isCounting) {
                    if (seconds > 0 && seconds <= 59) {
                        seconds--;
                    } else {
                        seconds = 59;
                    }
                    secondsView.setText(String.format(Locale.US, "%02d", seconds));
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCounting = true;
                alarmImage.setVisibility(View.INVISIBLE);
                CountDownTimer timer = new CountDownTimer((seconds + minutes * 60) * 1000, 500) {
                    int inc = 0;
                    final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.alarm);

                    @Override
                    public void onTick(long millisUntilFinished) {
                        inc++;
                        colonView.setVisibility(colonIsVisible ? View.VISIBLE : View.INVISIBLE);
                        colonIsVisible = !colonIsVisible;
                        if (inc % 2 == 0) {
                            countdown();
                        }
                    }

                    @Override
                    public void onFinish() {
                        mp.start();
                        Toast.makeText(MainActivity.this, "BEEP BEEP BEEP", Toast.LENGTH_LONG).show();
                        alarmImage.setVisibility(View.VISIBLE);
                        colonIsVisible = true;
                        colonView.setVisibility(colonIsVisible ? View.VISIBLE : View.INVISIBLE);
                        isCounting = false;
                        inc = 0;
                    }
                };
                timer.start();
            }
        });

    }

    private void countdown() {
        seconds--;
        if (seconds < 0 && minutes <= 0) {
            minutes = 0;
            minutesView.setText("00");
            seconds = 0;
            secondsView.setText("00");
            return;
        }   else if (seconds < 0) {
            minutes--;
            minutesView.setText(String.format(Locale.US, "%02d", minutes));
            seconds = 59;
        }
        secondsView.setText(String.format(Locale.US, "%02d", seconds));
    }
}