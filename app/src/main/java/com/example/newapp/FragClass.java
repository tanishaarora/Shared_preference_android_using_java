package com.example.newapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

public class FragClass extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar toolBar;
    BottomNavigationView navigationView;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_class);

        toolBar = (Toolbar) findViewById(R.id.frag_toolbar);
        toolBar.setTitle("Profile Activity");
        setSupportActionBar(toolBar);

        getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        navigationView = (BottomNavigationView) findViewById(R.id.nv_bottom);
        navigationView.setOnNavigationItemSelectedListener(this);

        HomeFragment fragment = new HomeFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_class, fragment);
        fragmentTransaction.commit();
    }


    //private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

//    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {

                case R.id.frag_home:
                    toolBar.setTitle("Home");
                    selectedFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frag_class, selectedFragment);
                    fragmentTransaction.commit();
                    return true;

                case R.id.frag_about:
                    toolBar.setTitle("About Us");
                    selectedFragment = new AboutFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frag_class, selectedFragment);
                    fragmentTransaction1.commit();
                    return true;

                case R.id.frag_contact:
                    toolBar.setTitle("Contact Us");
                    selectedFragment = new ContactFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.frag_class, selectedFragment);
                    fragmentTransaction2.commit();
                    return true;

                case R.id.frag_search:
                    toolBar.setTitle("Search");
                    selectedFragment = new SearchFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.frag_class, selectedFragment);
                    fragmentTransaction3.commit();
                    return true;
            }
            return false;
        };


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem funct){
        if(funct.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(funct);


    }
    }
