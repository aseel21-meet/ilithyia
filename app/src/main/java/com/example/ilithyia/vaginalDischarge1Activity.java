
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
import android.widget.TextView;

public class vaginalDischarge1Activity extends AppCompatActivity implements View.OnClickListener {
    private Button vis;
    private TextView opt1, opt2,q1,q2;
    private String [][] questions;
    private int count;
    private boolean game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaginal_discharge1);



        vis=findViewById(R.id.colorbtn);
        count=0;
        game=true;
        questions= new String[][]{
                {"1",
                        "Vaginal discharge is a ",
                        "fluid",
                        "solid",
                        "a"},
                {"2",
                        "The vaginal discharge has no job \n",
                        "True",
                        "False",
                        "b"},
                {"3",
                        "The amount of vaginal discharge might change when you are ",
                        "Ovulating",
                        "Breastfieding",
                        "ab"},
                {"4",
                        "Is any change in the smell/color/texture of vaginal discharge normal? ",
                        "Yes",
                        "No",
                        "b"},
                {"5",
                        "a young woman who has ____ Might notice shades of red in between periods, in her vaginal discharge \n",
                        "yeast infection",
                        "Irregular menstural cycle",
                        "b"},
                {"6",
                        "A change of diet may affect vaginal discharge color?",
                        "Yes",
                        "No",
                        "a"},
                {"7",
                        "which color might be a sign of sexually transmitted disease? \n",
                        "Yellow",
                        "blue",
                        "a"},
                {"8",
                        "bacterial vaginosis BV, is very",
                        "common",
                        "rare",
                        "a"},
                {"9",
                        "cottage cheese on my underwear oh no!",
                        "Before period",
                        "yeast infection"},
                {"10",
                        "when are you likely to get a browny discharge",
                        "while ovulating",
                        "At the end of your menstrual cycle",
                        "b"}
        };

        opt1=findViewById(R.id.opt1);
        opt1.setOnClickListener(this);
        opt2=findViewById(R.id.opt2);
        opt2.setOnClickListener(this);
        q2=findViewById(R.id.q2);
        q1=findViewById(R.id.q1);
        q1.setText(questions[0][1]);
        opt1.setText(questions[0][2]);
        opt2.setText(questions[0][3]);

        //button down below


    }

    @Override
    public void onClick(View v) {

        if(vdPopup.number<8 && game==true)
        {

            int idx=vdPopup.number;
            //find out if user answered correctly
            if( (v == opt2 && questions[idx][4].equals("b")) || (v == opt1 && questions[idx][4].equals("a")) || questions[idx][4].equals("ab")) //if first option picked and is correct,or both correct
            {
                    count++;
                    vdPopup.correct="correct";

            }

            else
                vdPopup.correct="wrong";

            vdPopup.number++;

            if(vdPopup.number==9)
            {
                game=false;
                q1.setText("blah");
            }
            else{
                q1.setText(questions[idx+1][1]);
                opt1.setText(questions[idx+1][2]);
                opt2.setText(questions[idx+1][3]);
                openVdDialog();
            }



        }
        else
        {
            vdPopup.number=0;
            q1.setText(count+"");
            opt2.setText("");
            opt1.setText("");
        }



    }
    public void openVdDialog()
    {
        vdPopup vdPopup=new vdPopup();

        vdPopup.show(getSupportFragmentManager(),"information dialog");
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
        return true;
    }


}