package com.example.newapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class RelativeLayout extends AppCompatActivity {
    Toolbar toolBar;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
//        toolBar.setTitle("Relative Layout");
        setSupportActionBar(toolBar);

        getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
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
