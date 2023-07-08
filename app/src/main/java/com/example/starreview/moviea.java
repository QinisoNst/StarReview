package com.example.starreview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class moviea extends ArrayAdapter<Movieaction>
{
    ArrayList<Movieaction> aCountryList = new ArrayList<>();
    public moviea(Context context, int textViewResourceId, ArrayList<Movieaction> objects)
    {
        super(context,textViewResourceId,objects);
        aCountryList = objects;
    }
    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.movielist_layout, null);
        TextView name = (TextView) v.findViewById(R.id.countryName);
        TextView release = (TextView) v.findViewById(R.id.countryName3);
        ImageView poster = (ImageView) v.findViewById(R.id.imageViewwwww);
        name.setText(aCountryList.get(position).getName());
        release.setText(aCountryList.get(position).getRelase());
        poster.setImageResource(aCountryList.get(position).getPostar());

        return v;
    }

}
