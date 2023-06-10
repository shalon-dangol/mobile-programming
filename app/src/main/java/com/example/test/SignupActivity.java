package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtEmail,edtConfirmEmail,edtFirstName,edtLastName,edtConfirmPassword,edtPassword;
    private TextView txtSignup;
    private AppCompatButton btnLogin;
    AppCompatButton btnSignup;
    String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_using_linear_layout);
        edtConfirmEmail= findViewById(R.id.edtConfirmEmail);
        edtEmail=findViewById(R.id.edtEmail);
        edtPassword=findViewById(R.id.edtPassword);
        edtFirstName=findViewById(R.id.edtFirstName);
        edtLastName=findViewById(R.id.edtLastName);
        edtConfirmPassword=findViewById(R.id.edtConfirmPassword);
        btnSignup = findViewById(R.id.btnSignup);


        btnSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if
                (edtFirstName.getText().toString().isEmpty()||edtLastName.getText().toString().isEmpty()||edtEmail.getText().toString().isEmpty()||
                        edtPassword.getText().toString().isEmpty()||
                        edtConfirmEmail.getText().toString().isEmpty()||edtConfirmPassword.getText().toString().isEmpty()){
                    Toast.makeText(SignupActivity.this,"Please Fill all the field.",Toast.LENGTH_SHORT).show();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
                    Toast.makeText(SignupActivity.this, "Please enter a valid email address.",
                            Toast.LENGTH_SHORT).show();
                } else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString()))
                {
                    Toast.makeText(SignupActivity.this, "Passwords do not match.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupActivity.this, "Sign up successful!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}