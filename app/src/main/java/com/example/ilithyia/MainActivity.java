package com.example.ilithyia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private androidx.cardview.widget.CardView card13,card1,card2,card3,card4,card5,card6,card7,card11,card8;

    private SearchView homeSearch;
    private class Article{
        String title;
        String content;
        String imageUrl;
        private Article(String title, String content, String imageUrl){
            this.title = title;
            this.content = content;
            this.imageUrl = imageUrl;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button down below

        //articles
        card1 = findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 = findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 = findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 = findViewById(R.id.card4);
        card4.setOnClickListener(this);
        card5 = findViewById(R.id.card5);
        card5.setOnClickListener(this);
        card11 = findViewById(R.id.card11);
        card11.setOnClickListener(this);
        card6 = findViewById(R.id.card6);
        card6.setOnClickListener(this);
        card7 = findViewById(R.id.card7);
        card7.setOnClickListener(this);
        card8 = findViewById(R.id.card8);
        card8.setOnClickListener(this);
        card13=findViewById(R.id.card13);
        card13.setOnClickListener(this);
        homeSearch = findViewById(R.id.homeSearch);
        homeSearch.setOnClickListener(this);

    }
    //when items are clicked on
    @Override
    public void onClick(View view) {
        //go to home page

        if(view.getId()== R.id.card1) {
            Intent intent = new Intent(this, ArticlesActivity.class);
            intent.putExtra("article_title","Contraceptives");
            startActivity(intent);

        }
        else if(view.getId()== R.id.card2) {
            Intent intent = new Intent(this,ArticlesActivity.class);
            intent.putExtra("article_title","Male Puberty");
            startActivity(intent);
        }
        else if(view.getId()== R.id.card3) {
            Intent intent = new Intent(this,ArticlesActivity.class);
            intent.putExtra("article_title","Female Puberty");
            startActivity(intent);
        }
        else if(view.getId()== R.id.card4) {
            Intent intent = new Intent(this,ArticlesActivity.class);
            intent.putExtra("article_title","consent");
            startActivity(intent);
        }
        else if(view.getId()== R.id.card5) {
            Intent intent = new Intent(this,ArticlesActivity.class);
            intent.putExtra("article_title","STD vs. STI");
            startActivity(intent);
        }
        else if(view.getId()== R.id.card11) {
            Intent intent = new Intent(this,ArticlesActivity.class);
            intent.putExtra("article_title","PMS");
            startActivity(intent);
        }
        else if (view.getId() == R.id.card6){
            Intent intent = new Intent(this,FemaleAnatomyQuizActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.card7){
            Intent intent = new Intent(this,vaginalDischarge1Activity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.card8){
            Intent intent = new Intent(this,MaleAnatomyGameActivity.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.card13)
        {
            Intent intent=new Intent(this, sex101GameActivity.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.homeSearch ){
            Intent intent = new Intent (this, DiscoverActivity.class);
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


}