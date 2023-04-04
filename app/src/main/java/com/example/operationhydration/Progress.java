package com.example.operationhydration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Progress extends AppCompatActivity {
Button button1, button3, button4;
    static double  goal = 12, current = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        double added = intent.getDoubleExtra("addedWater",0);
        double manualGoal = intent.getDoubleExtra("manualGoal",12);
        double calculated = intent.getDoubleExtra("calculatedGoal",12);
        int buttonCheck = intent.getIntExtra("buttonCheck", 0);

        current += added;
        current = (double)Math.round(current * 100d) / 100d;

        manualGoal = (double)Math.round(manualGoal * 100d) / 100d;
        calculated = (double)Math.round(calculated * 100d) / 100d;

        if(buttonCheck == 1)
            goal = calculated;
        else
            goal = manualGoal;


        double percentDone = current/goal;
        percentDone = ((double)Math.round(percentDone* 100d) / 100d) * 100;

        TextView textCurrent = findViewById(R.id.goal_text);
        textCurrent.setText("" + goal);

        TextView textGoal = findViewById(R.id.current_text);
        textGoal.setText("" + current);

        TextView textPercentDone = findViewById(R.id.percent_done);
        textPercentDone.setText("" + percentDone + "%");



        button1 = findViewById(R.id.to_water);
        button1.setOnClickListener(v -> openProgress());

        button3 = (Button) findViewById(R.id.to_settings);
        button3.setOnClickListener(v -> openSettings());

        button4 = (Button) findViewById(R.id.to_info);
        button4.setOnClickListener(v -> openInfo());
    }

    public void openProgress(){
        Intent intent = new Intent(this, AddWater.class);
        startActivity(intent);
    }

    public void openSettings(){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openInfo(){
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
}