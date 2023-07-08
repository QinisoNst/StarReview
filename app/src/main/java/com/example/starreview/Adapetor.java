package com.example.starreview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapetor extends ArrayAdapter<Items>
{
    ArrayList<Items> CountryList = new ArrayList<>();
    public Adapetor(Context context, int textViewResourceId,ArrayList<Items>objects)
    {
        super(context, textViewResourceId, objects);
        CountryList = objects;
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
        v = inflater.inflate(R.layout.nana_layout, null);
        TextView textView = (TextView) v.findViewById(R.id.countryName);
        textView.setText(CountryList.get(position).getCountryName());
        return v;
    }

}

