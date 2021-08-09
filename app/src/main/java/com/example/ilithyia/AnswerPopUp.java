package com.example.ilithyia;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnswerPopUp extends AppCompatActivity implements View.OnClickListener{

    private Message selectedFromList;
    private DatabaseReference dbref;
    private Button submitAns;
    private EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_pop_up);
        dbref= FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/").getReference("message");
        submitAns=findViewById(R.id.submitAns);
        submitAns.setOnClickListener(this);
        text=findViewById(R.id.answerEdit);
        if(getIntent().getExtras() != null) {
            selectedFromList = (Message) getIntent().getSerializableExtra("m");
        }




    }

    @Override
    public void onClick(View view) {
        String ans=text.getText().toString();
        selectedFromList.setAnswer(ans);
        dbref.child(selectedFromList.getKey()).setValue(selectedFromList);
        Intent intent=new Intent(this, QandAActivity.class);
        startActivity(intent);
        //Message selectedFromList=dbref.getValue(Message.class);


    }
}