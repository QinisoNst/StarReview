package com.example.starreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class neww extends AppCompatActivity {

    ListView CountryNames;
    ArrayList<Items> CountryList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);
        CountryNames =(ListView)findViewById(R.id.ListView);

        CountryList.add(new Items("Anime",R.drawable.github));
        CountryList.add(new Items("Si-Fi",R.drawable.robot));
        CountryList.add(new Items("Action",R.drawable.raised));

        final Adapetor countryAdapter = new Adapetor (this,R.layout.home_layout,CountryList);
        CountryNames.setAdapter(countryAdapter);

        CountryNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l)
            {
                Toast.makeText(getApplicationContext(),CountryList.get(i).show(),Toast.LENGTH_LONG).show();
            }}
        );

        CountryNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view , int i , long l) {
                if (CountryList.get(0).equals(CountryList.get(i))) {
                    startActivity(new Intent(getApplicationContext() , animes.class));
                    overridePendingTransition(0 , 0);
                    return;
                } else if (CountryList.get(1).equals(CountryList.get(i))) {
                    startActivity(new Intent(getApplicationContext() , sifis.class));
                    overridePendingTransition(0 , 0);
                    return;
                } else if (CountryList.get(2).equals(CountryList.get(i))) {
                    startActivity(new Intent(getApplicationContext() , actions.class));
                    return;
                }
                return ;
            }
        });
        //--------------------------------------------------------------------------------------------

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigtion);

        bottomNavigationView.setSelectedItemId(R.id.nav_movie);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_movie:
                        startActivity(new Intent(getApplicationContext(), action.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_setting:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),nana.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(),search.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        //----------------------------------------------------------------------------------------------

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Trailer Category");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
}