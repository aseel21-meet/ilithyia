package com.example.ilithyia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DiscoverActivity extends AppCompatActivity implements View.OnClickListener {
    private Button homebtn,librarybtn,discoverbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        homebtn = findViewById(R.id.homebtn);
        homebtn.setOnClickListener(this);
        librarybtn = findViewById(R.id.librarybtn);
        librarybtn.setOnClickListener(this);
        discoverbtn = findViewById(R.id.discoverbtn);
        discoverbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //go to home page
        if (view == homebtn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        //go to discover page
        else if (view == discoverbtn) {
            Intent intent = new Intent(this, DiscoverActivity.class);
            startActivity(intent);
        }
        //go to library
        else if (view == librarybtn) {
            Intent intent = new Intent(this, LibraryActivity.class);
            startActivity(intent);
        }
    }

    //adds menu to page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bar, menu);
        return true;
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


}