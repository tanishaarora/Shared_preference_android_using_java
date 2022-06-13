package com.example.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class UserName extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);

        ArrayList<String> values = new ArrayList<String>();
        values.add("Tanisha");
        values.add("Lovely");
        values.add("Shagun");
        values.add("Vanshika");
        values.add("Ruba");
        values.add("Pragati");
        values.add("Amrita");
        values.add("Tanvi");
        values.add("Anshita");
        values.add("Kriti");
        values.add("Deeksha");
        values.add("Astha");
        values.add("Priyanka");
        values.add("Sara");
        values.add("Nitibha");
        values.add("Yashi");
        values.add("Aayushi");
        values.add("Kylie");
        values.add("Palak");
        values.add("Nisha");
        values.add("Shivani");
        values.add("Shefa");
        values.add("Komal");
        values.add("Akruti");
        values.add("Pooja");

        RecyclerAdapter arrayAdapter = new RecyclerAdapter(R.layout.custom, values);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(arrayAdapter);

    }
}