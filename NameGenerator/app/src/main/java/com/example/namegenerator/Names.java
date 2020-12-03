package com.example.namegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Names extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        TextView name = findViewById(R.id.textViewPirateName);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                name.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name.setText(getRandomName());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private String getRandomName() {
        String[] first = getResources().getStringArray(R.array.first);
        String[] last = getResources().getStringArray(R.array.last);
        return first[(int) (Math.random() * first.length)] + " " + last[(int) (Math.random() * last.length)];
    }
}