package com.example.newapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.newapp.utility.Helper;

import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    //AppBarConfiguration appBarConfiguration;
    //ActivityMainBinding binding;
    EditText user_id, password;
    TextView loginPage;
    Button login;
    Toolbar toolbar;

    String correct_userid = "admin";
    String correct_password = "123456";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user_id = (EditText) findViewById(R.id.user_id);
        password = (EditText) findViewById(R.id.password);
        loginPage = (TextView) findViewById(R.id.login_page);
        login = (Button) findViewById(R.id.login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Login Activity");
        setSupportActionBar(toolbar);

        getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetValidation();

            }
        });
    }

    public void SetValidation()
    {
        if(TextUtils.isEmpty(user_id.getText().toString()) || TextUtils.isEmpty(password.getText().toString()))
        {
            Toast.makeText(Login.this , "Enter required information", Toast.LENGTH_LONG).show();

        }
        else if(user_id.getText().toString().equals(correct_userid))
        {
            if(password.getText().toString().equals(correct_password))
            {
                sharedpreferences = getSharedPreferences(Helper.MyPREFERENCES, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Helper.Name, "aa");
                editor.putString(Helper.Email, "abc@gmail.com");
                editor.putString(Helper.Phone, "7575567896");
                editor.putString(Helper.Gender, "Female");
                editor.putString(Helper.Hobbies, "Travelling");
                editor.putString(Helper.Country, "India");
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), RegistrationActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(Login.this, "Incorrect password", Toast.LENGTH_LONG).show();


            }
        }else{
            Toast.makeText(Login.this, "Incorrect user_id / password", Toast.LENGTH_LONG).show();

        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem funct){
        if(funct.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(funct);
    }

}