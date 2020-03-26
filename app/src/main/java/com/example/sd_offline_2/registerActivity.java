package com.example.sd_offline_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class registerActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    EditText username;
    EditText  password;
    EditText confirm_password;
    EditText  email;
    TextView birthdate;
    Button selectdate;
    Button signup;
    DatePickerDialog datePickerDialog;
    int day;
    int month;
    int year;
    Calendar calendar;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Spinner spinner = findViewById(R.id.genderSelect_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.genders,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);
        email = (EditText) findViewById(R.id.email);
        selectdate = (Button) findViewById(R.id.select_date);
        birthdate = (TextView) findViewById(R.id.birthDate);
        signup = (Button) findViewById(R.id.signup);

        selectdate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_MONTH);
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);


                DatePickerDialog datePickerDialog = new DatePickerDialog(registerActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                birthdate.setText(day + " / " + (month+1) + " / " + year);

                            }
                        }, 0, 0, 0);
                datePickerDialog.show();

            }

        }
        );
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
         gender = parent.getItemAtPosition(position).toString();
        if(gender.equals("_ _ _ _")==false) {
            Toast.makeText(parent.getContext(), gender, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public  void signedup(View v)
    {
        String check_username = username.getText().toString();
        String check_password = password.getText().toString();
        String check_confirm_password = confirm_password.getText().toString();
        String check_email = confirm_password.getText().toString();
        String check_gender = gender;

        if(check_username!=null  && check_password!=null &&check_confirm_password !=null && check_email!=null && gender.equals("_ _ _ _")==false && !birthdate.getText().toString().equals("Date of Birth")) {
            Intent login = new Intent(registerActivity.this, loginActivity.class);
            login.putExtra("username", username.getText().toString());
            login.putExtra("pass", password.getText().toString());
            Toast.makeText(getApplicationContext(),"Account Created Successfully",Toast.LENGTH_SHORT).show();
            startActivity(login);
        }
        else
        {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Please fill up the form correctly");
            dlgAlert.setTitle("Error Message");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
    }

}
