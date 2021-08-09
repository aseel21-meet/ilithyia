package com.example.ilithyia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private Button submitbtn;
    private EditText emailEdit, passwordEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        emailEdit=findViewById(R.id.emailedit);
        passwordEdit=findViewById(R.id.passwordedit);
        submitbtn=findViewById(R.id.submitbtn);
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance("https://ilithy-64c52-default-rtdb.europe-west1.firebasedatabase.app/");
        submitbtn.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if(view == submitbtn){
            String email=emailEdit.getText().toString()+"";
            String password=passwordEdit.getText().toString()+"";
            createUser(email, password);
        }
    }
    public void createUser(String email, String password){
        if(!email.equals("") && !password.equals("")) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String uid = mAuth.getCurrentUser().getUid().toString();
                                database.getReference("Users").child(uid).setValue(new User(email, password,false));
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}