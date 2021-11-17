package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.gson.Gson;

public class ServicesActivity extends AppCompatActivity {
    Gson gson = new Gson();

    String json;
    ShippingManifest data;

    CheckBox customs;
    CheckBox transport;
    CheckBox transportManpower;
    CheckBox discharge;
    CheckBox dischargeManpower;
    CheckBox loading;
    CheckBox loadingManpower;
    CheckBox warehousing;
    CheckBox warehousingManpower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Intent intent = getIntent();
        json = intent.getStringExtra("JSON");
        data = (ShippingManifest) intent.getSerializableExtra("JSON_DATA");

        //Create Checkboxes for the Additional Services
        transportManpower = findViewById(R.id.cbTransportManpower);
        transport = findViewById(R.id.cbTransport);
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

        dischargeManpower = findViewById(R.id.cbDischargingManpower);
        discharge = findViewById(R.id.cbDischarging);
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

        loadingManpower = findViewById(R.id.cbLoadingManpower);
        loading = findViewById(R.id.cbLoading);
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

        warehousingManpower = findViewById(R.id.cbWarehousingManpower);
        warehousing = findViewById(R.id.cbWarehousing);
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

        customs = findViewById(R.id.cbCustoms);

        Button toEstimate = (Button) findViewById(R.id.bToEstimate);
        toEstimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save the data to the JSON variable
                saveServices();
                //Launch the estimate Activity
                openEstimate(v);
            }
        });

    }

    public void saveServices() {
        if (customs.isChecked())
            data.setCustomsClearance("YES");
        else
            data.setCustomsClearance("NO");

        if (transport.isChecked())
            data.setTransport("YES");
        else
            data.setTransport("NO");

        if (transportManpower.isChecked())
            data.setTransportAdditionalManpower("YES");
        else
            data.setTransportAdditionalManpower("NO");

        if (discharge.isChecked())
            data.setDischarging("YES");
        else
            data.setDischarging("NO");

        if (dischargeManpower.isChecked())
            data.setDischargingAdditionalManpower("YES");
        else
            data.setDischargingAdditionalManpower("NO");

        if (loading.isChecked())
            data.setLoading("YES");
        else
            data.setLoading("NO");

        if (loadingManpower.isChecked())
            data.setLoadingAdditionalManpower("YES");
        else
            data.setLoadingAdditionalManpower("NO");

        if (warehousing.isChecked())
            data.setWarehousing("YES");
        else
            data.setWarehousing("NO");

        if (warehousingManpower.isChecked())
            data.setWarehousingAdditionalManpower("YES");
        else
            data.setWarehousingAdditionalManpower("NO");

        json = gson.toJson(data);

        Log.d(this.getLocalClassName(), "Attempting to save appended JSON data\n" + json);
    }

    public void openEstimate(View view) {
        Intent intent = new Intent(this, EstimateActivity.class);

        intent.putExtra("JSON_DATA", data);
        intent.putExtra("JSON", json);
        startActivity(intent);
    }
}