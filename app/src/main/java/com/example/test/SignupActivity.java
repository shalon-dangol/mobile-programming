package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
AppCompatButton btnSignup;
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_using_linear_layout);
        email= getIntent().getStringExtra("Email");
        btnSignup = findViewById(R.id.btnSignup);
//        Log.d("Email Address",email);
        Toast.makeText(this,email,Toast.LENGTH_LONG).show();

        btnSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.putExtra("Result","result Return");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}