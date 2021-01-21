package com.example.pd_babahovgleb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Pokemon[] pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemons = ;
        ListView pokemonListView = findViewById(R.id.listViewPokemons);
        pokemonListView.setAdapter(new PokemonAdapter(this, pokemons));

    }
}