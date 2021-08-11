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

public class SecondVImageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button one,two,three,four,five;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_vimage);




        //buttons for parts
        one = findViewById(R.id.one);
        one.setOnClickListener(this);
        two = findViewById(R.id.two);
        two.setOnClickListener(this);
        three = findViewById(R.id.three);
        three.setOnClickListener(this);
        four = findViewById(R.id.four);
        four.setOnClickListener(this);
        five = findViewById(R.id.five);
        five.setOnClickListener(this);




    }
    //when items are clicked on
    @Override
    public void onClick(View view) {
        //go to home page

        if(view == one){
            InfoDialog.number=7;
            openDialog();
        }
        else if(view == two){
            InfoDialog.number=8;
            openDialog();
        }
        else if(view == three){
            InfoDialog.number=9;
            openDialog();
        }
        else if(view == four){
            InfoDialog.number=10;
            openDialog();
        }
        else if(view == five){
            InfoDialog.number=11;
            openDialog();
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
        else if(id== R.id.discoverI){
            Intent intent = new Intent(this,DiscoverActivity.class);
            startActivity(intent);
        }
        return true;
    }
    //create dialog
    public void openDialog(){
        InfoDialog infoDialog=new InfoDialog();

        infoDialog.show(getSupportFragmentManager(),"information dialog");

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}