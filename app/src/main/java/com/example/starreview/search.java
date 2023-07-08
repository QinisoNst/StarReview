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
import android.widget.ListView;
import android.widget.SearchView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class search extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    ListView lista;
    searcha adapter;
    SearchView editsearch;
    String[] animalNameList;
    String[] animalNameLista;
    Uri[]animalNameListaa;
    int [] animalNameListaaa;
    ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        animalNameList = new String[]{"Deadpool", "Ready Player One", "Bad Boys II" , "Fast Five", "Kingsman" ,"Star Wars",
                "Avengers", "Blade Runner", "Mad Max", "District 9","Spirited Away" , "Wolf Children", "Your Name" , "Paprika",
                "Interstella 5555"};

        lista = (ListView) findViewById(R.id.ListView);

        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new searcha(this, arraylist);

        // Binds the Adapter to the ListView
        lista.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.Search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigtion);
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
         lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view , int i , long l) {


                if (arraylist.get(i).getAnimalName().equals("Deadpool")) {
                    startActivity(new Intent(getApplicationContext() , action.class));
                    overridePendingTransition(0 , 0);
                    return;
                }

                else if (arraylist.get(i).getAnimalName().equals("Ready Player One")) {
                    startActivity(new Intent(getApplicationContext() , action.class));
                    overridePendingTransition(0 , 0);
                    return;
                }
                else if (arraylist.get(i).getAnimalName().equals("Bad Boys II")) {
                    startActivity(new Intent(getApplicationContext() , action.class));
                    overridePendingTransition(0 , 0);
                    return;
                }
                else if (arraylist.get(i).getAnimalName().equals("Fast Five")) {
                    startActivity(new Intent(getApplicationContext() , action.class));
                    overridePendingTransition(0 , 0);
                    return;
                }
                else if (arraylist.get(i).getAnimalName().equals("Kingsman")) {
                    startActivity(new Intent(getApplicationContext() , action.class));
                    overridePendingTransition(0 , 0);
                    return;
                }
                else if (arraylist.get(i).getAnimalName().equals("Star Wars")) {
                    startActivity(new Intent(getApplicationContext() , sifi.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Avengers")) {
                    startActivity(new Intent(getApplicationContext() , sifi.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Blade Runner")) {
                    startActivity(new Intent(getApplicationContext() , sifi.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Mad Max")) {
                    startActivity(new Intent(getApplicationContext() , sifi.class));
                    return;
                }
                else if (arraylist.get(i).getAnimalName().equals("District 9")) {
                    startActivity(new Intent(getApplicationContext() , sifi.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Spirited Away")) {
                    startActivity(new Intent(getApplicationContext() , anime.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Wolf Children")) {
                    startActivity(new Intent(getApplicationContext() , anime.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Interstella 5555")) {
                    startActivity(new Intent(getApplicationContext() , anime.class));
                    return;
                }
                else if (arraylist.get(i).getAnimalName().equals("Your Name")) {
                    startActivity(new Intent(getApplicationContext() , anime.class));
                    return;

                }
                else if (arraylist.get(i).getAnimalName().equals("Paprika")) {
                    startActivity(new Intent(getApplicationContext() , anime.class));
                    return;

                }






                return ;
            }
        });

        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }


}
