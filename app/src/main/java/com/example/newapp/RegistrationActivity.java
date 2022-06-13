package com.example.newapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.service.autofill.RegexValidator;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


import com.example.newapp.utility.Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    EditText name, email, password, confirmPassword, phone;
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox checkA, checkB, checkC, checkD;
    Button complete;
    String gender;
    String hobby;
    String text;

    String mobilePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Spinner eSpinner;
    ArrayAdapter<CharSequence> myAdapter;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);
        confirmPassword = (EditText) findViewById(R.id.cpass);
        phone = (EditText) findViewById(R.id.phone);
        radioGroup = (RadioGroup) findViewById(R.id.rGroup);
        checkA = (CheckBox) findViewById(R.id.checkA);
        checkB = (CheckBox) findViewById(R.id.checkB);
        checkC = (CheckBox) findViewById(R.id.checkC);
        checkD = (CheckBox) findViewById(R.id.checkD);
        complete = (Button) findViewById(R.id.complete);

        //autoCompleteTextView = findViewById(R.id.spinner);

        eSpinner = (Spinner) (findViewById(R.id.spinner));
        myAdapter = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eSpinner.setAdapter(myAdapter);

        toolbar = (Toolbar) findViewById(R.id.toolbar_reg);
        toolbar.setTitle("Registration Activity");
        setSupportActionBar(toolbar);

        getSupportActionBar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    StringBuffer result = new StringBuffer();
                // result.append("Hobbies:\n")
                String nam = name.getText().toString();
                String mail = email.getText().toString().trim();
                String passwd = password.getText().toString();
                String cnpass = confirmPassword.getText().toString();
                String ph = phone.getText().toString().trim();


                int radio = radioGroup.getCheckedRadioButtonId();
                /*Bundle bundle = new Bundle();
                bundle.putString("Name", nam);
                bundle.putString("E-mail", mail);
                bundle.putString("Phone number", ph);
                bundle.putInt("Gender", radio);
                bundle.putString("Hobbies",hobby);
                bundle.putString("country",text);*/


//                Intent inte = new Intent (RegistrationActivity.this,RegistrationActivity2.class );
                //              startActivity(inte);


                boolean check = validation(nam, mail, passwd, cnpass, ph, radio);
                if (check == true) {
                    radioButton = findViewById(radio);
                    gender = radioButton.getText().toString();

                    hobby = "";
                    if (checkA.isChecked()) {
                        hobby = hobby + checkA.getText().toString() + ",";
                    }
                    if (checkB.isChecked()) {
                        hobby = hobby + checkB.getText().toString() + ",";
                    }
                    Log.d("RegistrationActivity", "hobby==" + hobby);
                    if (checkC.isChecked()) {
                        hobby = hobby + checkC.getText().toString() + ",";
                    }
                    if (checkD.isChecked()) {
                        hobby = hobby + checkD.getText().toString() + ",";
                    }
                    hobby = hobby.substring(0, hobby.length() - 1);


                    //int spinner = eSpinner.getSelectedItemPosition();
                    //eSpinner = findViewById(spinner);
                    text = eSpinner.getSelectedItem().toString();

                    Intent intent = new Intent(getApplicationContext(), RegistrationActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                    SharedPreferences sharedpref = getSharedPreferences(Helper.MyPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpref.edit();

                    editor.putString(Helper.Name, nam);
                    editor.putString(Helper.Email, mail);
                    editor.putString(Helper.Phone, ph);
                    editor.putString(Helper.Gender, gender);
                    editor.putString(Helper.Hobbies, hobby);
                    editor.putString(Helper.Country, text);
                    editor.apply();

                 /*   String Name = sharedpref.getString("nameKey", "No value");
                    String Email = sharedpref.getString("emailKey", "No value");
                    String Phone = sharedpref.getString("phoneKey", "No value");
                    String Gender = sharedpref.getString("genderKey", "No value");
                    String Hobby = sharedpref.getString("hobbiesKey", "No value");
                    String Country = sharedpref.getString("countryKey", "No value");*/

                    //                  Intent intent = new Intent(getApplicationContext(), RegistrationActivity2.class);
                    //intent.putExtras(bundle);
                    //              startActivity(intent);
                    //Toast.makeText(getApplicationContext(), "Data is valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

private boolean validation(String nam, String mail, String passwd, String cnpass, String ph, int radio) {
    if (nam.length() == 0)
    {
        name.setError("Name cannot be empty");
        return false;
    } else if (!mail.matches(emailPattern))
    {
        email.setError("Invalid e-mail");
        return false;
    } else if (passwd.length() == 0)
    {
        password.setError("Password cannot be empty");
        return false;
    }
    else if(!cnpass.equals(passwd)){
        confirmPassword.setError("Password does not match");
        return false;

    }
        else if (ph.length() == 0 && !ph.matches(mobilePattern)){
            phone.setError("Enter phone number");
            return false;
    }else if (radio == -1)
    {
        Toast.makeText(RegistrationActivity.this, "You have not selected any of the gender", Toast.LENGTH_LONG).show();
        return false;
    }
        // else if(checkA.isChecked()){
         //   result.append(checkA.getText()).toString().append("\n");

        else if (!checkA.isChecked() && !checkB.isChecked() && !checkC.isChecked() && !checkD.isChecked())
    {
        Toast.makeText(RegistrationActivity.this, "Check any of the hobby", Toast.LENGTH_LONG).show();
        return false;

    }
        else if(eSpinner.getSelectedItemPosition() == 0 )
        {
            Toast.makeText(RegistrationActivity.this, "Please select country", Toast.LENGTH_LONG).show();

            return false;

    }
    else if(nam.length() == 0 && !mail.matches(emailPattern) && passwd.length() == 0 && !cnpass.equals(passwd)
    && ph.length() == 0 && !ph.matches(mobilePattern)) {
        Toast.makeText(getApplicationContext(), "Please fill all the information", Toast.LENGTH_SHORT).show();
    return  false;
    }
        else {
            return true;
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