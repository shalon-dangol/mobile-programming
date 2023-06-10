package com.example.test;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtEmail,edtPassword;
    private AppCompatButton btnLogin;
    private TextView txtForgotPassword, txtSignup, txtWelcome;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initToolbar();
        findView();
    }
    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Login");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.home){
            Toast.makeText(this,"home icon clicked", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()== R.id.search){
            Toast.makeText(this,"search icon clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
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
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtEmail.getText().toString().isEmpty()&&edtPassword.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this,"username and password is empty",Toast.LENGTH_LONG).show();
                }
                else if(edtPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this,"password is empty",Toast.LENGTH_LONG).show();
                }
                else if(edtEmail.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Username is empty",Toast.LENGTH_LONG).show();
                }
                else{
                    LaunchDashBoardActivity();
                }
            }
        });
    }

    private void LaunchDashBoardActivity(){
        Intent intent = new Intent(this, DashboardActivity.class);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnLogin){

        }
        else if(view.getId()==R.id.txtSignup){
            Intent intent = new Intent(LoginActivity.this, ListActivity.class);
            intent.putExtra("Email","Email Address");
            signupActivityLauncher.launch(intent);
//            edtEmail.getText().toString().trim()
//            startActivity(intent);
//            finish();
//            startActivityForResult(intent,100);
        }
    }

    ActivityResultLauncher<Intent> signupActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()== Activity.RESULT_OK){
                        Intent data = result.getData();
                        Toast.makeText(LoginActivity.this,data.getStringExtra("Result"),Toast.LENGTH_SHORT).show();
                    }
                }
            });
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==100&&resultCode==RESULT_OK){
            Toast.makeText(this, data.getStringExtra("Result"), Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}