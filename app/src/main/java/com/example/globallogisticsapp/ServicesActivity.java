package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.gson.Gson;

public class ServicesActivity extends AppCompatActivity {
    Gson gson = new Gson();

    String json;
    String shippingType;
    ShippingManifest data;

    CheckBox customs;
    EditText customsCost;

    CheckBox transport;
    EditText transportCost;

    CheckBox transportManpower;
    EditText transportManpowerCost;

    CheckBox discharge;
    EditText dischargeCost;

    CheckBox dischargeManpower;
    EditText dischargeManpowerCost;

    CheckBox loading;
    EditText loadingCost;

    CheckBox loadingManpower;
    EditText loadingManpowerCost;

    CheckBox warehousing;
    EditText warehousingCost;

    CheckBox warehousingManpower;
    EditText warehousingManpowerCost;

    CheckBox demurrage;
    EditText demurrageCost;

    CheckBox detention;
    EditText detentionCost;

    CheckBox tariff;
    EditText tariffCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Intent intent = getIntent();
        json = intent.getStringExtra("JSON");
        data = (ShippingManifest) intent.getSerializableExtra("JSON_DATA");
        shippingType = intent.getStringExtra("SHIPPING_TYPE");

        //Create Checkboxes for the Additional Services
        transportCost = findViewById(R.id.etTransportCost);
        transportManpowerCost = findViewById(R.id.etTransportManpowerCost);

        transportManpower = findViewById(R.id.cbTransportManpower);
        transport = findViewById(R.id.cbTransport);
        transport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    transportManpower.setVisibility(View.VISIBLE);
                    transportCost.setVisibility(View.VISIBLE);

                }
                else
                {
                    transportManpower.setVisibility(View.GONE);
                    transportManpower.setChecked(false);
                    transportCost.setVisibility(View.GONE);

                }
            }
        });

        transportManpower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    transportManpowerCost.setVisibility(View.VISIBLE);

                }
                else
                {
                    transportManpowerCost.setVisibility(View.GONE);

                }
            }
        });

        dischargeCost = findViewById(R.id.etDischargeCost);
        dischargeManpowerCost = findViewById(R.id.etDischargeManpowerCost);

        dischargeManpower = findViewById(R.id.cbDischargingManpower);
        discharge = findViewById(R.id.cbDischarging);
        discharge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    dischargeManpower.setVisibility(View.VISIBLE);
                    dischargeCost.setVisibility(View.VISIBLE);

                }
                else
                {
                    dischargeManpower.setVisibility(View.GONE);
                    dischargeManpower.setChecked(false);
                    dischargeCost.setVisibility(View.GONE);

                }
            }
        });

        dischargeManpower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    dischargeManpowerCost.setVisibility(View.VISIBLE);

                }
                else
                {
                    dischargeManpowerCost.setVisibility(View.GONE);

                }
            }
        });

        loadingCost = findViewById(R.id.etLoadingCost);
        loadingManpowerCost = findViewById(R.id.etLoadingManpowerCost);

        loadingManpower = findViewById(R.id.cbLoadingManpower);
        loading = findViewById(R.id.cbLoading);
        loading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    loadingManpower.setVisibility(View.VISIBLE);
                    loadingCost.setVisibility(View.VISIBLE);

                }
                else
                {
                    loadingManpower.setVisibility(View.GONE);
                    loadingManpower.setChecked(false);
                    loadingCost.setVisibility(View.GONE);

                }
            }
        });

        loadingManpower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    loadingManpowerCost.setVisibility(View.VISIBLE);

                }
                else
                {
                    loadingManpowerCost.setVisibility(View.GONE);

                }
            }
        });

        warehousingCost = findViewById(R.id.etWarehousingCost);
        warehousingManpowerCost = findViewById(R.id.etWarehousingManpowerCost);

        warehousingManpower = findViewById(R.id.cbWarehousingManpower);
        warehousing = findViewById(R.id.cbWarehousing);
        warehousing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    warehousingManpower.setVisibility(View.VISIBLE);
                    warehousingCost.setVisibility(View.VISIBLE);


                }
                else
                {
                    warehousingManpower.setVisibility(View.GONE);
                    warehousingManpower.setChecked(false);
                    warehousingCost.setVisibility(View.GONE);


                }
            }
        });

        warehousingManpower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    warehousingManpowerCost.setVisibility(View.VISIBLE);


                }
                else
                {
                    warehousingManpowerCost.setVisibility(View.GONE);


                }
            }
        });

        customsCost = findViewById(R.id.etCustomsCost);
        customs = findViewById(R.id.cbCustoms);
        customs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    customsCost.setVisibility(View.VISIBLE);


                }
                else
                {
                    customsCost.setVisibility(View.GONE);


                }
            }
        });

        demurrageCost = findViewById(R.id.etDemurrageCost);
        demurrage = findViewById(R.id.cbDemurrage);
        demurrage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    demurrageCost.setVisibility(View.VISIBLE);


                }
                else
                {
                    demurrageCost.setVisibility(View.GONE);


                }
            }
        });

        detentionCost = findViewById(R.id.etDetentionCost);
        detention = findViewById(R.id.cbDetention);
        detention.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    detentionCost.setVisibility(View.VISIBLE);


                }
                else
                {
                    detentionCost.setVisibility(View.GONE);


                }
            }
        });

        tariffCost = findViewById(R.id.etTariffCost);
        tariff = findViewById(R.id.cbTariff);
        tariff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    tariffCost.setVisibility(View.VISIBLE);


                }
                else
                {
                    tariffCost.setVisibility(View.GONE);


                }
            }
        });

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

        Button toManifest = (Button) findViewById(R.id.bBackToManifest);
        toManifest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManifest(v);
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
        intent.putExtra("SHIPPING_TYPE",shippingType);
        startActivity(intent);
    }

    public void openManifest(View view) {
        Intent intent = new Intent(this, ManifestDataActivity.class);
        intent.putExtra("SHIPPING_TYPE",shippingType);
        startActivity(intent);
    }
}