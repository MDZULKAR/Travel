package com.example.travel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button button = findViewById(R.id.forgotsend);
        EditText editText = findViewById(R.id.forgotmail);
        final String email = editText.getText().toString().trim();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d("ForgotPassword", "Email sent.");
                                        Toast.makeText(ForgotPassword.this,"The mail to recover password has been sent",Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                }
                            });
                }else {
                    Toast.makeText(ForgotPassword.this,"Please enter a valid email",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}