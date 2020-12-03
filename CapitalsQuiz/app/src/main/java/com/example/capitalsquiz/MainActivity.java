package com.example.capitalsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView wordList;
    private TextView wordLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordList = findViewById(R.id.listViewWords);
        wordLength = findViewById(R.id.textViewWordLength);

        String[] words = {"The", "Quick", "Brown", "Fox", "Jumps", "Over", "The", "Lazy", "Dog"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        wordList.setAdapter(arrayAdapter);

        wordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int length = words[position].length();
                wordLength.setText(words[position] + " has length " + length);
            }
        });
    }
}