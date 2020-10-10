package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText names,emails,passs,passcomfirms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        names = findViewById(R.id.signupUsernameEdittext);
        passcomfirms = findViewById(R.id.signupPasswordConfirm_edittext);
        passs = findViewById(R.id.signupPasswordEdittext);
        emails = findViewById(R.id.signupEmail);


// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Button button =findViewById(R.id.signup_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emails.getText().toString();
                final String pass = passs.getText().toString();
                final String passcomfirm = passcomfirms.getText().toString();
                final String name = names.getText().toString();
                    if(pass.equals(passcomfirm)){
                        mAuth.createUserWithEmailAndPassword(email, pass)
                                .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d("Signup", "createUserWithEmail:success");
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            Intent intent = new Intent(Signup.this,Destinations.class);
                                            startActivity(intent);
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Log.w("Signup", "createUserWithEmail:failure", task.getException());
                                            Toast.makeText(Signup.this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show();
                                        }

                                        // ...
                                    }
                                });
                    }
            }
        });

        TextView textView = findViewById(R.id.back_to_login_txt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}