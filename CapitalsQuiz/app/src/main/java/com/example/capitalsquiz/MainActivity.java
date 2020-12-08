package com.example.capitalsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView stateList;
    private TextView capital;
    private TextView state;
    private String[] states;
    private String[] capitals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stateList = findViewById(R.id.listViewStates);
        capital = findViewById(R.id.textViewCapital);
        state = findViewById(R.id.textViewState);

        states = getResources().getStringArray(R.array.states);
        capitals = getResources().getStringArray(R.array.capitals);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, states);
        stateList.setAdapter(arrayAdapter);

        stateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                capital.setText(capitals[position]);
                state.setText(states[position]);
            }
        });
    }
}