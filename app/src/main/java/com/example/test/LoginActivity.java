package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtEmail,edtPassword;
    private AppCompatButton btnLogin;
    private TextView txtForgotPassword, txtSignup, txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        findView();
    }
    private void findView(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword= findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtWelcome = findViewById(R.id.txtWelcome);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtSignup = findViewById(R.id.txtSignup);
        btnLogin.setOnClickListener(this);
        txtSignup.setOnClickListener(this);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(edtEmail.getText().toString().isEmpty()&&edtPassword.getText().toString().isEmpty()){
//
//
//                }
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnLogin){

        }
        else if(view.getId()==R.id.txtSignup){
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();

        }
    }
}