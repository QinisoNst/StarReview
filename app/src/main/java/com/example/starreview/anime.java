package com.example.starreview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class anime extends AppCompatActivity {
    ListView CountryNames;
    ArrayList<Movieaction> aCountryList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        CountryNames =(ListView)findViewById(R.id.ListView);

        //generating date for the ArrayList
        aCountryList.add(new Movieaction("Spirited Away","1998",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.lkoa),R.drawable.spirited,"Spirited Away s a 2001 Japanese animated fantasy film written and directed by Hayao Miyazaki, animated by Studio Ghibli .Spirited Away tells the story of Chihiro Ogino (Hiiragi), a 10-year-old girl who, while moving to a new neighbourhood, enters the world of Kami (spirits) of Japanese Shinto folklore."));
        aCountryList.add(new Movieaction("Wolf Children","2014",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.lkoa),R.drawable.okami,"Wolf Children is a 2012 Japanese anime film directed and co-written by Mamoru Hosoda. The story follows a young mother who is left to raise two half-human half-wolf children, Ame and Yuki, after their werewolf father dies"));
        aCountryList.add(new Movieaction("Your Name","2016",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.iko),R.drawable.your,"Your Name is a 2016 Japanese animated romantic/fantasy/drama film Mitsuha Miyamizu is a high school girl living in the town of Itomori near Hida region. She is bored with small town life and wishes to be a handsome Tokyo boy in her next life. She begins to switch bodies intermittently with Taki Tachibana, a high school boy in Tokyo."));
        aCountryList.add(new Movieaction("Paprika","2010",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.lkoa),R.drawable.paprikaposter,"Paprika s a 2006 Japanese science-fiction psychological thriller anime film co-written and directed by Satoshi Kon, In the near future, a device called the DC Mini allows the user to view people's dreams."));
        aCountryList.add(new Movieaction("Interstella 5555","2000",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.lkoa),R.drawable.interstella,"interstella 5555: The 5tory of the 5ecret 5tar 5ystem is a 2003 adult animated musical science fiction film and the visual realization of Discovery, the second studio album by Daft Punk. Interstella 5555 tells the story of the abduction and rescue of an interstellar pop band"));

        //moving data from Movie to the Adapter
        moviea countryAdapter = new moviea (this,R.layout.movielist_layout,aCountryList);
        CountryNames.setAdapter(countryAdapter);

        CountryNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view , final int position , long id) {
                {

                        Intent intent = new Intent(anime.this,movie.class);
                        String noo = aCountryList.get(position).getName();
                        String nuri = aCountryList.get(position).getMovie().toString();
                        String me = aCountryList.get(position).getDescription();

                        intent.putExtra("Name",noo);
                        intent.putExtra("Descrition",me);
                        intent.putExtra("Movie",nuri);

                        startActivity(intent);


                }
            }
        });

    //----------------------------------------------------------------------------------------------
        //set BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigtion);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    //use switch to direct users where to go depending on the cash

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
//setTitle ,lniialize Toolbar and overrideActionbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Anime");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
