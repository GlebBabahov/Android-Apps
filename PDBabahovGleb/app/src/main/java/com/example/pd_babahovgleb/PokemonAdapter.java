package com.example.pd_babahovgleb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private Pokemon [] pokemons;
    private static LayoutInflater inflater;

    public PokemonAdapter(Context context, Pokemon[] pokemons) {
        this.context = context;
        this.pokemons = pokemons;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pokemons.length;
    }

    @Override
    public Object getItem(int position) {
        return pokemons[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.person_row_layout, null);
        }

        TextView nameText = convertView.findViewById(R.id.textViewName);
        TextView idText = convertView.findViewById(R.id.textViewID);
        ImageView imageIcon = convertView.findViewById(R.id.imageViewIcon);

        Pokemon poke = pokemons[position];

        nameText.setText(poke.getName().getEnglish());
        imageIcon.setImage;

    }
}
