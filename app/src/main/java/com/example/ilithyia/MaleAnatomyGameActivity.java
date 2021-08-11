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
import android.widget.TextView;

import java.util.MissingFormatArgumentException;

public class MaleAnatomyGameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button one,two,three,four,five,six,seven,eight;
    private TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_anatomy_game);



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
        six = findViewById(R.id.six);
        six.setOnClickListener(this);
        seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);
        eight=findViewById(R.id.eight);
        eight.setOnClickListener(this::onClick);



    }
    //when items are clicked on
    @Override
    public void onClick(View view) {

        if(view == one){
            MaleDialog.number=0;
            openDialog();
        }
        else if(view == two){
            MaleDialog.number=1;
            openDialog();
        }
        else if(view == three){
            MaleDialog.number=2;
            openDialog();
        }
        else if(view == four){
            MaleDialog.number=3;
            openDialog();
        }
        else if(view == five){
            MaleDialog.number=4;
            openDialog();
        }
        else if(view == six){
            //title.setText("hello");
            MaleDialog.number=5;
            openDialog();
        }
        else if(view == seven){
            MaleDialog.number=6;
            openDialog();

        }
        else if(view == eight){
            MaleDialog.number=7;
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
            Intent intent = new Intent(this, MainActivity.class);
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
        MaleDialog infoDialog=new MaleDialog();

        infoDialog.show(getSupportFragmentManager(),"information dialog");
    }


}