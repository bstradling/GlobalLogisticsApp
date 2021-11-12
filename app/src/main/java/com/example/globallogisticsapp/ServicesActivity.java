package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //Create Checkboxes for the Additional Services
        public void onCheckboxClicked(View view) {





            CheckBox checkBox4 = findViewById(R.id.checkBox4);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        additionalManpower.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        additionalManpower.setVisibility(View.GONE);

                    }
                }
            });

            CheckBox checkBox5 = findViewById(R.id.checkBox5);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        additionalManpower.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        additionalManpower.setVisibility(View.GONE);

                    }
                }
            });

            CheckBox checkBox6 = findViewById(R.id.checkBox6);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        additionalManpower.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        additionalManpower.setVisibility(View.GONE);

                    }
                }
            });

            CheckBox checkBox8 = findViewById(R.id.checkBox8);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                    {
                        additionalManpower.setVisibility(View.VISIBLE);

                    }
                    else
                    {
                        additionalManpower.setVisibility(View.GONE);

                    }
                }
            });




        }
    }
}