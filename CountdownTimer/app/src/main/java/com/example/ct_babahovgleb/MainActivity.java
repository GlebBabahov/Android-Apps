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
    private int seconds = 5;
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
                    int oldMins = minutes;
                    int oldSecs = seconds;
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
                        minutes = oldMins;
                        minutesView.setText(String.format(Locale.US, "%02d", minutes));
                        seconds = oldSecs;
                        secondsView.setText(String.format(Locale.US, "%02d", seconds));
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

/* TODO
In this program you will use the CountDownTimer class to build a ... count down timer (very original on my part). Your
timer must have the ability to change the number of minutes and seconds on the clock.

* Your timer must save the inputted seconds/minutes if the screen is rotated (before clicking start). Once the timer is
started, if the screen is rotated you are not required to keep the timer working (read below for an 'exceeds' challenge).

Exceeds Challenges

* Have two entirely different layouts for if the screen is portrait or landscape. Have the program automatically adjust
when switched. You will need to research this yourself (I may make a video in the future if I deem it needed for another
project, but it is not a tricky concept).

* Once started, change your 'start' button to 'pause'. There is a cancel() method that can be applied to a
CountDownTimer object, but there is no resume. When a person clicks pause - stop the timer, then let them resume at the
same time it was paused at.

* Make the timer save states if the user rotates the screen. If the timer was currently counting down it should stay
counting down with the same time it was before rotating.
 */