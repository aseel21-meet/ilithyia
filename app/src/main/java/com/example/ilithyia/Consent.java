package com.example.ilithyia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Consent extends AppCompatActivity implements View.OnClickListener{
    private TextView yesbtn, nobtn;
    Timer timer;
    private int num,count,score;
    private ImageView pic;
    private final Random rand=new Random();
    private boolean isYes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent);
        count=0;
        score=0;
        pic=findViewById(R.id.pic);
        yesbtn=findViewById(R.id.yesbtn);
        yesbtn.setOnClickListener(this);
        nobtn=findViewById(R.id.nobtn);
        nobtn.setOnClickListener(this);
        senerio();
        timer = new Timer();






    }

    @Override
    public void onClick(View v) {
        if(v==yesbtn && isYes)
        {
            score=score+10;
        }
        count++;
        yesbtn.setTextColor(Color.rgb(152,251,152));
        nobtn.setTextColor(Color.rgb(128, 0, 32));
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                yesbtn.setTextColor(Color.rgb(0, 0, 0));
                nobtn.setTextColor(Color.rgb(0, 0, 0));

            }
        },1000);
        if(count==3)
        {
            pic.setImageResource(R.mipmap.swan_coins_round);
            nobtn.setText("");
            yesbtn.setText("you gained a score of "+score);
        }
        else{
            senerio();
        }




    }//onclick
    public boolean senerio()
    {
        num=rand.nextInt(11-1)+1;

        if(num==1)
        {
            pic.setImageResource(R.mipmap.consent1_foreground);
            isYes=true;
        }
        if(num==2)
        {
            pic.setImageResource(R.mipmap.consent2_foreground);
            isYes=true;

        }
        if(num==3)
        {
            pic.setImageResource(R.mipmap.consent3_foreground);
            isYes=false;
        }
        if(num==4)
        {
            pic.setImageResource(R.mipmap.consent4_foreground);
            isYes=false;
        }
        if(num==5)
        {
            pic.setImageResource(R.mipmap.consent5_foreground);
            isYes=false;
        }
        if(num==6)
        {
            pic.setImageResource(R.mipmap.consent6_foreground);
            isYes=false;
        }
        if(num==7)
        {
            pic.setImageResource(R.mipmap.consent7_foreground);
            isYes=false;
        }
        if(num==8 || num==9)
        {

            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    pic.setImageResource(R.mipmap.consent8_foreground);
                }
            },1000);
            pic.setImageResource(R.mipmap.consent9_foreground);
            isYes=false;
        }
        if(num==10)
        {
            pic.setImageResource(R.mipmap.consent10_foreground);
            isYes=false;
        }
        if(num==11)
        {
            pic.setImageResource(R.mipmap.consent11_foreground);
            isYes=false;
        }
        return isYes;
    }//senerio
}


/*timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){


            }
        },2000);*/