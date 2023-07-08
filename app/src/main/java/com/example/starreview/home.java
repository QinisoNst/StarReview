package com.example.starreview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    ListView CountryNames;
    ArrayList<Items> CountryList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist);

        CountryNames =(ListView)findViewById(R.id.ListView);

        CountryList.add(new Items("Anime"));
        CountryList.add(new Items("Si-Fi"));
        CountryList.add(new Items("Action"));

        final Adapetor countryAdapter = new Adapetor (this,R.layout.nana_layout,CountryList);
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
                    startActivity(new Intent(getApplicationContext() , anime.class));
                    overridePendingTransition(0 , 0);
                    return;
                } else if (CountryList.get(1).equals(CountryList.get(i))) {
                    startActivity(new Intent(getApplicationContext() , sifi.class));
                    overridePendingTransition(0 , 0);
                    return;
                } else if (CountryList.get(2).equals(CountryList.get(i))) {
                    startActivity(new Intent(getApplicationContext() , action.class));
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
                        startActivity(new Intent(getApplicationContext(), home.class));
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
        toolbar.setTitle("Category");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
}