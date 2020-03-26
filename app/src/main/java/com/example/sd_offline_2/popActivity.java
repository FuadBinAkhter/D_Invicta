package com.example.sd_offline_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import org.w3c.dom.Text;

public class popActivity extends AppCompatActivity {

    Button exit;
    Button donate;
    EditText amount;
    String money;

    amount_money sharedData = amount_money.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        donate = (Button) findViewById(R.id.donate);
        amount = (EditText)  findViewById(R.id.amount);
        exit = (Button)findViewById(R.id.back);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));

    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    public  void donate(View v)
    {
        String donation;
        donation =amount.getText().toString();
        if(isInteger(donation))
        {
           // int add = Integer.parseInt(donation);
            sharedData.setDonation(Integer.valueOf(donation));
            Toast.makeText(getApplicationContext(),"Donation Successful",Toast.LENGTH_SHORT).show();
            Intent back = new Intent(popActivity.this,homeActivity.class);
            startActivity(back);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please Enter an amount to donate",Toast.LENGTH_SHORT).show();
        }
    }

    public  void exit(View v)
    {
        Intent back = new Intent(popActivity.this,homeActivity.class);
        startActivity(back);
    }




}
