package com.example.memes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Drawable> memes;
    private int cur = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView text = findViewById(R.id.textView);
//        String x = getResources().getString(R.string.greeting);
//        text.setText(x);
//
//        Button b = findViewById(R.id.button);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, getResources().getText(R.string.toast), Toast.LENGTH_SHORT).show();
//            }
//        });

        memes = new ArrayList<>();
        memes.add(getResources().getDrawable(R.drawable.birb));
        memes.add(getResources().getDrawable(R.drawable.book));
        memes.add(getResources().getDrawable(R.drawable.furbie));
        memes.add(getResources().getDrawable(R.drawable.uber));
        memes.add(getResources().getDrawable(R.drawable.well));
        ImageView meme = findViewById(R.id.imageViewMeme);
        meme.setImageDrawable(memes.get(cur));

        ImageButton left = findViewById(R.id.imageButtonLeft);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cur > 0) {
                    cur--;
                    meme.setImageDrawable(memes.get(cur));
                } else {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.noPrev), Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton right = findViewById(R.id.imageButtonRight);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cur < memes.size() - 1) {
                    cur++;
                    meme.setImageDrawable(memes.get(cur));
                } else {
                    Toast.makeText(MainActivity.this, getResources().getText(R.string.noNext), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}