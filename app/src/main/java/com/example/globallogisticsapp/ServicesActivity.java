package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class ServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        //Create Checkboxes for the Additional Services

        CheckBox transportManpower = findViewById(R.id.cbTransportManpower);
        CheckBox transport = findViewById(R.id.cbTransport);
        transport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    transportManpower.setVisibility(View.VISIBLE);

                }
                else
                {
                    transportManpower.setVisibility(View.GONE);
                    transportManpower.setChecked(false);

                }
            }
        });

        CheckBox dischargeManpower = findViewById(R.id.cbDischargingManpower);
        CheckBox discharge = findViewById(R.id.cbDischarging);
        discharge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    dischargeManpower.setVisibility(View.VISIBLE);

                }
                else
                {
                    dischargeManpower.setVisibility(View.GONE);
                    dischargeManpower.setChecked(false);

                }
            }
        });

        CheckBox loadingManpower = findViewById(R.id.cbLoadingManpower);
        CheckBox loading = findViewById(R.id.cbLoading);
        loading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    loadingManpower.setVisibility(View.VISIBLE);

                }
                else
                {
                    loadingManpower.setVisibility(View.GONE);
                    loadingManpower.setChecked(false);

                }
            }
        });

        CheckBox warehousingManpower = findViewById(R.id.cbWarehousingManpower);
        CheckBox warehousing = findViewById(R.id.cbWarehousing);
        warehousing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    warehousingManpower.setVisibility(View.VISIBLE);

                }
                else
                {
                    warehousingManpower.setVisibility(View.GONE);
                    warehousingManpower.setChecked(false);

                }
            }
        });

    }
}