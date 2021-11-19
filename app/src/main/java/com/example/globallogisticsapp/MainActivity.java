package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton rbMaritime;
    RadioButton rbAir;
    RadioButton rbRoad;

    Boolean maritime;
    Boolean air;
    Boolean road;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMaritime = (RadioButton) findViewById(R.id.rbMaritime);
        rbAir = (RadioButton) findViewById(R.id.rbAir);
        rbRoad = (RadioButton) findViewById(R.id.rbRoad);

        Button toManifest = (Button) findViewById(R.id.bToManifest);

        toManifest.setEnabled(false);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();

                if (radioButtonID > 0) {
                    toManifest.setEnabled(rbMaritime.isChecked()||rbRoad.isChecked()||rbAir.isChecked());
                }
            }
        });

        toManifest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openManifest(v); }
        });
    }

    public void openManifest(View view) {
        Intent intent = new Intent(this, ManifestDataActivity.class);

        maritime = rbMaritime.isChecked();
        air = rbAir.isChecked();
        road = rbRoad.isChecked();
        String shipping;

        if (maritime){
            shipping = "Maritime";
            intent.putExtra("SHIPPING_TYPE", shipping);
        }
        else if (air){
            shipping = "Air";
            intent.putExtra("SHIPPING_TYPE", shipping);
        }
        else{
            shipping = "Road";
            intent.putExtra("SHIPPING_TYPE", shipping);
        }

        //Log
        Log.d(this.getLocalClassName(), "Creating intent with " +
                "maritime = " + maritime + "\nair = " + air + "\nroad = " + road);

        startActivity(intent);
    }
}