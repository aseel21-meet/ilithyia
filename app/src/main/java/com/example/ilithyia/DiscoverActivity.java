package com.example.ilithyia;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
public class DiscoverActivity extends AppCompatActivity implements View.OnClickListener {
    ListView search_articles;
    GridLayout cats;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        cats = (GridLayout) findViewById(R.id.cats);
        search_articles = (ListView) findViewById(R.id.search_articles);
        arrayArticles = new ArrayList<String>();
        arrayArticles.addAll(Arrays.asList(getResources().getStringArray(R.array.myArticles)));
        adapter = new ArrayAdapter<String>(
                DiscoverActivity.this,
                android.R.layout.simple_list_item_1,
                arrayArticles
        );
        search_articles.setAdapter(adapter);
        search_articles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedFromList = (String) (search_articles.getItemAtPosition(i));
                if (selectedFromList.equals("Male Puberty")){
                    Intent intent = new Intent(DiscoverActivity.this , ArticlesActivity.class);
                    intent.putExtra("article_title","Male Puberty");
                    intent.putExtra("audioUrl","");
                    startActivity(intent);
                }
                if (selectedFromList.equals("Female Puberty")){
                    Intent intent = new Intent(DiscoverActivity.this , ArticlesActivity.class);
                    intent.putExtra("article_title","Female Puberty");
                    intent.putExtra("audioUrl","https://www.mboxdrive.com/Female-puberty-Aseel.mp3");
                    startActivity(intent);
                }
                if (selectedFromList.equals("Contraceptives 101")){
                    Intent intent = new Intent(DiscoverActivity.this , ArticlesActivity.class);
                    intent.putExtra("article_title","Contraceptives");
                    intent.putExtra("audioUrl","");
                    startActivity(intent);
                }
                if (selectedFromList.equals("Consent")){
                    Intent intent = new Intent(DiscoverActivity.this , ArticlesActivity.class);
                    intent.putExtra("article_title","consent");
                    intent.putExtra("audioUrl","");
                    startActivity(intent);
                }
                if (selectedFromList.equals("STD VS STI")){
                    Intent intent = new Intent(DiscoverActivity.this , ArticlesActivity.class);
                    intent.putExtra("article_title","STD vs. STI");
                    intent.putExtra("audioUrl","");
                    startActivity(intent);
                }
                if (selectedFromList.equals("PMS")){
                    Intent intent = new Intent(DiscoverActivity.this , ArticlesActivity.class);
                    intent.putExtra("article_title","PMS");
                    intent.putExtra("audioUrl","");
                    startActivity(intent);
                }
            }
        });
    }




    @Override
    public void onClick(View view) {

    }

    //adds menu to page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bar, menu);
        MenuInflater inflater1=getMenuInflater();
        inflater1.inflate(R.menu.search_menu,menu);
        MenuItem item =menu.findItem(R.id.search_articles);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                search_articles.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                search_articles.setVisibility(View.VISIBLE);
                cats.setVisibility(View.GONE);
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    //functionality for menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //go to settings page
        if (id == R.id.settingsI){
            Intent intent = new Intent(this,LoggedInPro.class);
            startActivity(intent);
        }
        //go to proffetionals page
        else if(id== R.id.proI){
            Intent intent = new Intent(this,ProActivity.class);
            startActivity(intent);
        }
        //go to q&a
        else if(id == R.id.qnaI){
            Intent intent = new Intent(this,QandAActivity.class);
            startActivity(intent);
        }
        //go to about us page
        else if(id == R.id.aboutUsI){
            Intent intent = new Intent(this,aboutUs.class);
            startActivity(intent);
        }
        else if(id == R.id.homeI){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }


}