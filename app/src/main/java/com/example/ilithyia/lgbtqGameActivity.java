package com.example.ilithyia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class lgbtqGameActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView lgbtq1, bisexual2,nonbinary3,pansexual4,lesbian5,genderqueer6,trans7,asexual8;
    private EditText asexualEdit, genderQueerEdit, bisexualEdit, pansexualEdit,transgenderEdit, lesbianEdit, nonBinaryEdit, lgbtqEdit;
    private TextView asexualEditT, genderQueerEditT,bisexualEditT, pansexualEditT, transgenderEditT, lesbianEditT, nonBinaryEditT,lgbtqEditT;
    private Button submit;
    private String asexualEditS, genderQueerEditS, bisexualEditS, pansexualEditS,transgenderEditS, lesbianEditS, nonBinaryEditS, lgbtqEditS;
    private int score;
    private TextView instructions;
    private DatabaseReference  userref;
    private FirebaseUser user;
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //numbers for title change
        setContentView(R.layout.activity_lgbtq_game);
        lgbtq1=findViewById(R.id.lgbtq1);
        bisexual2=findViewById(R.id. bisexual2);
        nonbinary3=findViewById(R.id.nonbinary3);
        pansexual4=findViewById(R.id.pansexual4);
        lesbian5=findViewById(R.id.lesbian5);
        genderqueer6=findViewById(R.id.genderqueer6);
        trans7=findViewById(R.id.trans7);
        asexual8=findViewById(R.id.asexual8);

        //edit text
        lgbtqEdit=findViewById(R.id.lgbtqEdit);
        bisexualEdit=findViewById(R.id. bisexualEdit);
        nonBinaryEdit=findViewById(R.id.nonBinaryEdit);
        pansexualEdit=findViewById(R.id.pansexualEdit);
        lesbianEdit=findViewById(R.id.lesbianEdit);
        genderQueerEdit=findViewById(R.id.genderQueerEdit);
        transgenderEdit=findViewById(R.id.transgenderEdit);
        asexualEdit=findViewById(R.id.asexualEdit);

        //titles for color change
        lgbtqEditT=findViewById(R.id.lgbtqEditT);
        bisexualEditT=findViewById(R.id. bisexualEditT);
        nonBinaryEditT=findViewById(R.id.nonBinaryEditT);
        pansexualEditT=findViewById(R.id.pansexualEditT);
        lesbianEditT=findViewById(R.id.lesbianEditT);
        genderQueerEditT=findViewById(R.id.genderQueerEditT);
        transgenderEditT=findViewById(R.id.transgenderEditT);
        asexualEditT=findViewById(R.id.asexualEditT);


        //submit button
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(this);
        score=0;
        instructions=findViewById(R.id.instructions);

    }

    @Override
    public void onClick(View v) {
        lgbtqEditS=lgbtqEdit.getText().toString().trim();
        bisexualEditS=bisexualEdit.getText().toString().trim();
        nonBinaryEditS=nonBinaryEdit.getText().toString().trim();
        pansexualEditS=pansexualEdit.getText().toString().trim();
        lesbianEditS=lesbianEdit.getText().toString().trim();
        genderQueerEditS=genderQueerEdit.getText().toString().trim();
        transgenderEditS=transgenderEdit.getText().toString().trim();
        asexualEditS=asexualEdit.getText().toString().trim();

        if(lgbtqEditS.equals("1"))
        {
            lgbtqEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if(bisexualEditS.equals("2"))
        {
            bisexualEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if(nonBinaryEditS.equals("3"))
        {

            nonBinaryEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if(pansexualEditS.equals("4"))
        {

            pansexualEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if(lesbianEditS.equals("5"))
        {
            lesbianEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if(genderQueerEditS.equals("6"))
        {

            genderQueerEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if(transgenderEditS.equals("7"))
        {

            transgenderEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        if( asexualEditS.equals("8"))
        {

            asexualEditT.setTextColor(Color.rgb(152,251,152));
            score+=10;
        }
        lgbtq1.setText("LGBTQ+ flag");
        bisexual2.setText("Bisexual flag");
        nonbinary3.setText("Non-binary flag");
        pansexual4.setText("Pansexual flag");
        lesbian5.setText("Lesbian flag");
        genderqueer6.setText("GenderQueer flag");
        trans7.setText("Transgender flag");
        asexual8.setText("Asexual flag");
        submit.setEnabled(false);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userref= FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
        userID=user.getUid();
        LoggedInPro.TOTAL_SCORE=LoggedInPro.TOTAL_SCORE+score;
        userref.child(userID).child("score").setValue(LoggedInPro.TOTAL_SCORE);
        instructions.setText("Score is "+score);


    }//onclick
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