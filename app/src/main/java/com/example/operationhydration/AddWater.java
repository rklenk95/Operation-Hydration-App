package com.example.operationhydration;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddWater extends AppCompatActivity {
    Button button2, button3, button4, addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_water);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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

        button4 = (Button) findViewById(R.id.to_info);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfo();
            }
        });

        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> addWater());


        SeekBar seekBar = (SeekBar)findViewById(R.id.unit_bar);
        final TextView seekBarValue = (TextView)findViewById(R.id.seek_value);

        seekBarValue.setText(String.valueOf(0));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarValue.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void openAddWater()
    {
        Intent intent = new Intent(this, Progress.class);
        startActivity(intent);
    }

    public void openSettings()
    {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openInfo()
    {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    public void addWater()
    {
        Intent intent = new Intent(this, Progress.class);
        EditText editText = (EditText) findViewById(R.id.water_input);
        TextView unitText = (TextView) findViewById(R.id.seek_value);

        double number = Double.parseDouble(editText.getText().toString());
        int unitValue = Integer.parseInt((unitText.getText().toString()));

        if(unitValue == 1)
            number = number/8;


        intent.putExtra("addedWater",number);

        startActivity(intent);

    }
}

