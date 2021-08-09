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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class
QandAActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listView ;
    private ArrayList<Message> arrayList;
    private MessageArrayAdapter arrayAdapter;
    private EditText  sendTob, msgb;
    private String email, sendTo, msg;
    private DatabaseReference dbref ,userref;
    private Message message;
    private FirebaseDatabase db=FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/");
    private DatabaseReference root=db.getReference().child("message");
    private Button submit;
    private FirebaseUser user;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qand_aactivity);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userref=FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Users");
        userID=user.getUid();
        userref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                User userprofile=snapshot.getValue(User.class);
                if (user != null)
                {
                    email= user.getEmail();
                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        //send message to db
        sendTob=findViewById(R.id.sendTob);
        msgb=findViewById(R.id.msgb);
        submit=findViewById(R.id.submitcbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                msg=msgb.getText().toString();
                sendTo=sendTob.getText().toString();
                message= new Message(email, sendTo, msg);
                root.push().setValue(message);



            }
        });

//answered thingies list
        listView = findViewById(R.id.lst);
        arrayList=new ArrayList<>();
        dbref=FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/").getReference("message");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data:snapshot.getChildren()){
                    Message message = data.getValue(Message.class);
                    Toast.makeText(QandAActivity.this,message.toString(),Toast.LENGTH_LONG).show();
                    if(message.getIsPublished()==true)
                    {

                        arrayList.add(message);
                    }

                }
                arrayAdapter = new MessageArrayAdapter(QandAActivity.this,R.layout.list_item,arrayList);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    //when items are clicked on
    @Override
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
        else if(id == R.id.homeI){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}