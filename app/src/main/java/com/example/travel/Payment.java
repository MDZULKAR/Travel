package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    EditText name,cardNumber,cvv,expiryDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button button = findViewById(R.id.finishPaymentBtn);
        name = findViewById(R.id.fullNameTxtPayment);
        cardNumber = findViewById(R.id.cardNumberTxtPayment);
        cvv = findViewById(R.id.cvvTxtPayment);
        expiryDate = findViewById(R.id.expiryDatePayment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.length() == 0 && cardNumber.length() == 0 && cvv.length() == 0 && expiryDate.length() == 0){
                    Toast.makeText(Payment.this,"Please enther the valid information",Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(Payment.this, FinishScreen.class);
                startActivity(intent);
            }
        });
    }
}