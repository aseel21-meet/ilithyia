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

public class sex101GameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title, explanation;
    private Button next;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex101_game);
        title=findViewById(R.id.title);
        explanation=findViewById(R.id.explanation);
        next=findViewById(R.id.next);
        next.setOnClickListener(this);
        count=0;
    }


    @Override
    public void onClick(View v) {
        if (count == 0) {
            title.setText("Kissing");
            explanation.setText("kissing");

        }
        else if(count==1)
        {
            title.setText("Masturbation");
            explanation.setText(" Touching yourself in a way that causes arousal and can eventually lead to release. Could be done with the fingers or a toy, focusing on the genitals, breasts, or anywhere else that causes pleasure. \n" +
                    "Masturbation could be a good way to familiarize yourself with your body and your sexual preferences - what feels good and what doesn't. There is no harm in doing it. Most importantly, it's a matter of choice. You can decide to masturabte or not, and both options are totally okay!\n");
        }
        else if(count==2)
        {
            title.setText("Mutual Masturbation");
            explanation.setText("when two or more people touch each other in a way that creates Pleasure.\n" +
                    "\n");
        }
        else if(count==3)
        {
            title.setText("FIngering");
            explanation.setText("Using fingers to stimulate another person's genitals (typically refers to female ");

        }
        else if(count==4)
        {
            title.setText("Foreplay");
            explanation.setText("Any type of sexual play that happens before penetrative Sex. Could be Kissing, touching, talking… whatever feels good and creates arousal and a feeling of desire.\n");
        }
        else if(count==5)
        {
            title.setText("Oral sex");
            explanation.setText("Using the mouth and/or tongue to stimulate the other persons genitals, though it can also be used on the breasts, thighs or wherever feels good. \n \n     *You can NOT get pregnant from Oral sex, but safety measure should be used in order to not pass on Sexually transmitted infections. (link here articles that talk about contraceptives and STI and STD)\n");
        }
        else if(count==6)
        {
            title.setText("Non - penetrative Sex");
            explanation.setText(" Sexual acts that create arousal that do not involve penetration of the mouth, Vagina or Anus.");
        }
        else if(count==7)
        {
            title.setText("Penetrative sex (sexual intercourse)");
            explanation.setText(" When something (examples: Penis or a toy) goes inside the mouth, Vagina or Anus (the butt)\n");
        }
        else if(count==8)
        {
            title.setText("Vaginal Sex");
            explanation.setText("When a penis goes inside a Vagina.\n\n *Inorder to not get pregnant or get Sexually transmitted infections it is highly recommended to use contraceptives such as condoms. (link article to contraceptive devices)\n");
        }
        else if(count==9)
        {
            title.setText("Anal Sex");
            explanation.setText(" Use of a Toy or Penis inside the Anus (the opening of your digestive system where waste comes out from)\n");
        }
        count++;
        if(count>9)
        {
            next.setEnabled(false);
            count=0;
        }

    }
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