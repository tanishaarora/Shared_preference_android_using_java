package com.example.newapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class LIstDetails extends AppCompatActivity implements  RecyclerViewClickInterface {

    RecyclerView recyclerView2;
    ArrayList<ListModel> details = new ArrayList<ListModel>();
    Toolbar toolBar;

    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_details);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Details");
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        /*toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        details.add(new ListModel("Tanisha", 22, "New York", 1999));
        details.add(new ListModel("Lovely", 23, "Manhattan", 1998));
        details.add(new ListModel("Shagun", 24, "Ambedkar Nagar", 1997));
        details.add(new ListModel("Vanshika", 25, "Ayodhya", 1996));
        details.add(new ListModel("Simran", 26, "Dalhousie", 1995));
        details.add(new ListModel("Kishi", 27, "Srinagar", 1994));
        details.add(new ListModel("Ruba", 28, "Noida", 1993));
        details.add(new ListModel("Amrita", 29, "Shimla", 1992));
        details.add(new ListModel("Pragati", 30, "Manali", 1991));
        details.add(new ListModel("Tanvi", 31, "Auli", 1990));
        details.add(new ListModel("Astha", 13, "Ajmer", 2008));
        details.add(new ListModel("Anshita", 50, "Jaisalmer", 1971));
        details.add(new ListModel("Ayushi", 50, "Noida", 1971));
        details.add(new ListModel("Komal", 50, "Ajmer", 1971));
        details.add(new ListModel("Palak", 50, "New York", 1971));

        RecyclerAdapter2 arrayAdapter = new RecyclerAdapter2(R.layout.customtext, details, this);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Hello " + details.get(position).getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem funct){
        if(funct.getItemId() == android.R.id.home) {
                       finish();
        }
        return super.onOptionsItemSelected(funct);


    }
}
/*   switch (funct.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;*/
