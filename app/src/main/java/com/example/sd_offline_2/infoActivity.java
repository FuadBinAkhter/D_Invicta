package com.example.sd_offline_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class infoActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigation;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        logout = (Button) findViewById(R.id.logout);

        bottomNavigation.setSelectedItemId(R.id.navigation_info);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), homeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_donate:
                        startActivity(new Intent(getApplicationContext(), donatedActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_info:
                        return true;
                }
                return false;
            }
        });
    }

    public  void logout(View v)
    {
        Intent lg= new  Intent(infoActivity.this,loginActivity.class);
        Toast.makeText(getApplicationContext(),"Logout Successful",Toast.LENGTH_SHORT).show();
        startActivity(lg);
    }

}
