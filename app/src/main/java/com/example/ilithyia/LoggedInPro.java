package com.example.ilithyia;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class LoggedInPro extends AppCompatActivity implements View.OnClickListener{
    private ListView listView ;
    private  ArrayList<Message> arrayList;
    private DatabaseReference dbref, userref;
    private TextView title,scoresofar, qtitle;
    private FirebaseUser user;
    private String userID;
    private DatabaseReference reference,logged;
    private FirebaseAuth mAuth;
    private Message selectedFromList;
    private MessageArrayAdapter arrayAdapter;
    private User userprofile;
    private boolean isPro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_pro);
        listView = findViewById(R.id.lst);
        title=findViewById(R.id.title);
        scoresofar=findViewById(R.id.scoresofar);
        arrayList=new ArrayList<>();
        isPro=false;
        //Bundle extras=getIntent().getExtras();
        //title.setText(extras.getString("email"));
        qtitle=findViewById(R.id.qtitle);



        //set user email title
        //user profile
        user = FirebaseAuth.getInstance().getCurrentUser();
        userref=FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
        userID=user.getUid();
        userref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                userprofile=snapshot.getValue(User.class);
                if (user != null)
                {
                    title.setText(user.getEmail());
                    //isPro=userprofile.getIsPro()+"";
                }
                if(userprofile!=null)
                {
                    scoresofar.setText(userprofile.getScore()+"");
                    isPro=userprofile.getIsPro();
                   //String thing= userref.child(userID).child("score").getValue()+"";

                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });



        //list of msgs
        if(isPro==true) {
            qtitle.setVisibility(View.VISIBLE);
            dbref = FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/").getReference("message");
            dbref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        Message message = data.getValue(Message.class);
                        String id = data.getKey() + "";
                        message.setKey(id);

                        if (user.getEmail().equals(message.getSendTo()) && (message.getIsPublished() == false)) {

                            arrayList.add(message);
                        }

                    }
                    arrayAdapter = new MessageArrayAdapter(LoggedInPro.this, R.layout.list_item, arrayList);
                    listView.setAdapter(arrayAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    selectedFromList = (Message) (listView.getItemAtPosition(position));
                    arrayAdapter.remove(selectedFromList);
                    selectedFromList.setIsPublished(true);
                    dbref.child(selectedFromList.getKey()).setValue(selectedFromList);
                    Intent intent = new Intent(LoggedInPro.this, AnswerPopUp.class);
                    intent.putExtra("m", selectedFromList);
                    startActivity(intent);


                }
            });
        }

    }
    //nav functioning
    public void onClick(View view) {




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
        else if(id == R.id.homeI)
        {
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(id== R.id.discoverI){
            Intent intent = new Intent(this,DiscoverActivity.class);
            startActivity(intent);
        }
        return true;
    }
}