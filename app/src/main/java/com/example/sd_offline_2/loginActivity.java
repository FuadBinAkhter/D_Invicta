package com.example.sd_offline_2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    Button register;
    EditText username;
    EditText password;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = (Button)  findViewById(R.id.register);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);


    }

        public  void login(View v)
        {
            Bundle bundle = getIntent().getExtras();

            if(bundle==null)
            {
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

                dlgAlert.setMessage("Invalid username or password");
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
            else if(bundle!=null)
            {
                String username_check= bundle.getString("username");
                String password_check = bundle.getString("pass");

                String username_temp= username.getText().toString();
                String password_temp = password.getText().toString();

                if(username_temp.equals(username_check) && password_temp.equals(password_check))
                {
                    Intent menu_page = new Intent(loginActivity.this,homeActivity.class);
                    startActivity(menu_page);
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

                    dlgAlert.setMessage("Invalid username or password");
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

        public void register(View v)
        {
            Intent registerPage = new Intent(loginActivity.this,registerActivity.class);
            startActivity(registerPage);
        }

    }

