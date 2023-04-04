package com.example.operationhydration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info extends AppCompatActivity {
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button1 = (Button) findViewById(R.id.to_water);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProgress();
            }
        });

        button2 = (Button) findViewById(R.id.to_progress);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddWater();
            }
        });

        button3 = (Button) findViewById(R.id.to_settings);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }

    public void openProgress(){
        Intent intent = new Intent(this, AddWater.class);
        startActivity(intent);
    }

    public void openAddWater(){
        Intent intent = new Intent(this, Progress.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
}