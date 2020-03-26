package com.example.sd_offline_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);


        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigation.setSelectedItemId(R.id.navigation_home);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_donate:
                        startActivity(new Intent(getApplicationContext(), donatedActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_info:
                        startActivity(new Intent(getApplicationContext(), infoActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        }

    public void pop(View view){
        Intent pop= new Intent(homeActivity.this,popActivity.class);
        startActivity(pop);
    }

}
