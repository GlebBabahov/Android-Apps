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
                if (!s.toString().equals("")) {
                    String[] first = getResources().getStringArray(R.array.first);
                    String[] last = getResources().getStringArray(R.array.last);

                    StringBuilder str = new StringBuilder();
                    str.append(first[(int) (Math.random() * first.length)]);
                    str.append(" ");
                    str.append(s.toString());
                    str.append(" ");
                    str.append(last[(int) (Math.random() * last.length)]);
                    name.setText(str);
                } else {
                    name.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}