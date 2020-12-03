package com.example.songchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private TextView song;

    private int songIndex;
    private String[] songs =
            {"1. Imagine Dragons - I Don't Know Why"	,
                    "2. Imagine Dragons - Whatever It Takes",
                    "3. Imagine Dragons - Believer",
                    "4. Imagine Dragons - Walking the Wire",
                    "5. Imagine Dragons - Rise Up",
                    "6. Imagine Dragons - I'll Make It Up to You",
                    "7. Imagine Dragons - Yesterday",
                    "8. Imagine Dragons - Mouth of the River",
                    "9. Imagine Dragons - Thunder",
                    "10. Imagine Dragons - Start Over",
                    "11. Imagine Dragons - Dancing in the Dark"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song = findViewById(R.id.textViewSong);
        updateSong();
    }

    public void onButtonClickNext(View v) {
//        Button b = findViewById(v.getId());
        if (songIndex >= songs.length - 1) {
            songIndex = 0;
        } else {
            songIndex++;
        }
        updateSong();
    }

    public void onButtonClickPrev(View v) {
//        Button b = findViewById(v.getId());
        if (songIndex <= 0) {
            songIndex = songs.length - 1;
        } else {
            songIndex--;
        }
        updateSong();
    }

    private void updateSong() {
        song.setText(songs[songIndex]);
    }
}