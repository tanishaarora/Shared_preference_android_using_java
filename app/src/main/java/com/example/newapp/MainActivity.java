package com.example.newapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.newapp.utility.Helper;

//import androidx.navigation.ui.AppBarConfiguration;
//import com.example.newapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedpref  = getSharedPreferences(Helper.MyPREFERENCES, Context.MODE_PRIVATE);
        if(sharedpref.contains(Helper.Name)) {
            Intent intent1 = new Intent(getApplicationContext(), RegistrationActivity2.class);
            startActivity(intent1);
            finish();
        }
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.registration);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}