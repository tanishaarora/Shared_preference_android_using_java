package com.example.newapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.newapp.utility.Helper;

public class RegistrationActivity2 extends AppCompatActivity {

    TextView tvname, tvhobbies;
    TextView tvemail, tvradio, tvcountry;
    TextView tvph;
    String nam, mail, ph, radio, hobbies, country;
    Button details, logout, moredetails, frag, relative;

    SharedPreferences sharedpreferences;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);


        details = (Button) findViewById(R.id.userlist);
        logout = (Button) findViewById(R.id.logout);
        moredetails = (Button) findViewById(R.id.moredetails);
        frag = (Button) findViewById(R.id.frag_click);
        relative = (Button)findViewById(R.id.rL_example);



        sharedpreferences = getSharedPreferences(Helper.MyPREFERENCES, MODE_PRIVATE);
//        sharedpref  = getSharedPreferences(Helper.MyPREFERENCES, Context.MODE_PRIVATE);

        nam = sharedpreferences.getString("nameKey", "Name");
        mail = sharedpreferences.getString("emailKey", "E-mail");
        ph = sharedpreferences.getString("phoneKey", "Phone number");
        radio = sharedpreferences.getString("genderKey", "Gender");
        hobbies = sharedpreferences.getString("hobbiesKey", "Hobbies");
        country = sharedpreferences.getString("countryKey", "country");


        tvname = (TextView) findViewById(R.id.tvname);
        tvhobbies = (TextView) findViewById(R.id.tvhobbies);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvradio = (TextView) findViewById(R.id.tvradio);
        tvcountry = (TextView) findViewById(R.id.tvcountry);
        tvph = (TextView) findViewById(R.id.tvph);
        tvname.setText(nam);
        tvemail.setText(mail);
        tvph.setText(ph);
        tvradio.setText(radio);
        tvhobbies.setText(hobbies);
        tvcountry.setText(country);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserName.class);
                startActivity(intent);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity2.this);

                builder.setTitle("Confirm Exit")
                        .setMessage("Are you sure you want to exit this page")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                sharedpreferences.edit().clear().apply();
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", null);

                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        moredetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LIstDetails.class);
                startActivity(intent);
            }
        });

        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FragClass.class);
                startActivity(intent);
            }
        });

        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RelativeLayout.class);
                startActivity(intent);
            }
        });


       /* Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nam = bundle.getString("Name");
            mail = bundle.getString("E-mail");
            ph = bundle.getString("Phone number");
            radio = bundle.getString("Gender");
            hobbies = bundle.getString("Hobbies");
            country = bundle.getString("country");
        }
        tvname = (TextView) findViewById(R.id.tvname);
        tvemail = (TextView) findViewById(R.id.tvemail);
        tvph = (TextView) findViewById(R.id.tvph);
        tvradio = (TextView) findViewById(R.id.tvradio);
        tvhobbies = (TextView) findViewById(R.id.tvhobbies);
        tvcountry = (TextView) findViewById(R.id.tvcountry);
        tvname.setText(nam);
        tvemail.setText(mail);
        tvph.setText(ph);
        tvradio.setText(radio);
        tvhobbies.setText(hobbies);
        tvcountry.setText(country);*/
    }
    /*@Override
    public void onBackPressed() {

        this.finish();
        Intent intent= new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();

    }*/

}