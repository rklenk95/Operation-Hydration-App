package com.example.operationhydration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {
    Button button1, button2, button4, manual_button, calculated_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        button1 = (Button) findViewById(R.id.to_water);
        button1.setOnClickListener(v -> openProgress());

        button2 = (Button) findViewById(R.id.to_progress);
        button2.setOnClickListener(v -> openAddWater());

        button4 = (Button) findViewById(R.id.to_info);
        button4.setOnClickListener(v -> openInfo());

        manual_button = (Button) findViewById(R.id.update_button);
        manual_button.setOnClickListener(v -> updateGoal());

        calculated_button = (Button) findViewById(R.id.calculated_button);
        calculated_button.setOnClickListener(v -> calculateGoal());
    }

    public void openProgress(){
        Intent intent = new Intent(this, AddWater.class);
        startActivity(intent);
    }

    public void openAddWater(){
        Intent intent = new Intent(this, Progress.class);
        startActivity(intent);
    }

    public void openInfo(){
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    public void updateGoal(){
        Intent intent = new Intent(this, Progress.class);
        EditText editText = (EditText) findViewById(R.id.manual_goal);
        double number = Double.parseDouble(editText.getText().toString());


        intent.putExtra("manualGoal",number);

        startActivity(intent);

    }

    public void calculateGoal(){
        double ageBracket = 0;
        Intent intent = new Intent(this, Progress.class);
        EditText editText = (EditText) findViewById(R.id.age_input);
        double ageNumber = Double.parseDouble(editText.getText().toString());
        EditText editText2 = (EditText) findViewById(R.id.weight_input);
        double weightNumber = Double.parseDouble(editText2.getText().toString());

        if(ageNumber < 30)
        {
            ageBracket = 40;
        }
        else if(ageNumber < 56)
        {
            ageBracket = 35;
        }
        else
        {
            ageBracket = 30;
        }

        double calculation = ((weightNumber / 2.2 * ageBracket)/28.3)/8;


        int buttonCheck = 1;
        intent.putExtra("buttonCheck", buttonCheck);
        intent.putExtra("calculatedGoal",calculation);

        startActivity(intent);

    }
}