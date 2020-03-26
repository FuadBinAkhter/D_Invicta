package com.example.sd_offline_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class donatedActivity extends AppCompatActivity {
    TextView money;
    amount_money sharedData = amount_money.getInstance();
    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donted);


        updateUI();

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigation.setSelectedItemId(R.id.navigation_donate);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_home:
                        startActivity(new Intent(getApplicationContext(), homeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_donate:
                                return  true;
                    case R.id.navigation_info:
                        startActivity(new Intent(getApplicationContext(), infoActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


    }

    private  void updateUI()
    {
        money=(TextView)findViewById(R.id.money);
        String Amount_string = String.valueOf(sharedData.getDonation());
        money.setText(Amount_string+" TK");
    }

}
