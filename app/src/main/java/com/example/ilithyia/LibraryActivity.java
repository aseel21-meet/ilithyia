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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button homebtn,librarybtn,discoverbtn;
    ListView search_articles;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayArticles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        homebtn = findViewById(R.id.homebtn);
        homebtn.setOnClickListener(this);
        librarybtn = findViewById(R.id.librarybtn);
        librarybtn.setOnClickListener(this);
        discoverbtn = findViewById(R.id.discoverbtn);
        discoverbtn.setOnClickListener(this);
        search_articles = (ListView) findViewById(R.id.search_articles);
        arrayArticles = new ArrayList<String>();
        arrayArticles.addAll(Arrays.asList(getResources().getStringArray(R.array.myArticles)));
        adapter = new ArrayAdapter<String>(
                LibraryActivity.this,
                android.R.layout.simple_list_item_1,
                arrayArticles
        );
        search_articles.setAdapter(adapter);
        search_articles.setOnItemClickListener(this);
    }
    //when items are clicked on
    @Override
    public void onClick(View view) {
        //go to home page
        if (view == homebtn){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        //go to discover page
        else if(view == discoverbtn){
            Intent intent = new Intent(this,DiscoverActivity.class);
            startActivity(intent);
        }
        //go to library
        else if(view  == librarybtn){
            Intent intent = new Intent(this,LibraryActivity.class);
            startActivity(intent);
        }
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
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
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
            Intent intent = new Intent(this,SettingsActivity.class);
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
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        long article = adapter.getItemId(i);
        Toast.makeText(this,""+i,Toast.LENGTH_LONG).show();
    }
}