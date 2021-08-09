package com.example.ilithyia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    //Timer timer;
    private Button loginbtn, signupbtn;
    private Object Intent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
/*        timer = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                Intent intent = new Intent( IntroActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);*/
        loginbtn=findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);
        signupbtn=findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(this);
       // skipbtn=findViewById(R.id.skipbtn);
        //skipbtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view ==loginbtn)
        {
            Intent intent=new Intent(this, LogInActivity.class);
            startActivity(intent);

        }
        if (view ==signupbtn)
        {
            Intent intent=new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
        //if (view == skipbtn)
        //{
          //  Intent intent=new Intent(this, MainActivity.class);
            //startActivity(intent);
        //}
    }
}