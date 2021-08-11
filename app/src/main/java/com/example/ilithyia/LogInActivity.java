package com.example.ilithyia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText emailb, passwordb;
    private FirebaseAuth mAuth;
    private Button submitbtn;
    private String password;
    private TextView text;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        emailb=findViewById(R.id.emailedit);
        passwordb=findViewById(R.id.passwordedit);
        submitbtn=findViewById(R.id.submitbtn);
        submitbtn.setOnClickListener(this);
        text=findViewById(R.id.title);
        mAuth=FirebaseAuth.getInstance();


    }
    public void onClick(View view){
        email=emailb.getText().toString().trim();
        password=passwordb.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        logIn();
                    }
                    else {
                                           }
            }
        });
    }
    public void logIn()
    {
        Intent intent=new Intent(this, LoggedInPro.class);
        intent.putExtra("email",email);
        startActivity(intent);
    }

}