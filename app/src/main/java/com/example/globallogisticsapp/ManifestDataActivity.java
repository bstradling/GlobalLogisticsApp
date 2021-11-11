package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ManifestDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifest_data);
        //Depending on the shipping type selected set the manifest fields may change
        Gson gson = new Gson();

        Intent intent = getIntent();
        boolean maritime = intent.getBooleanExtra("MARITIME", false);
        boolean air = intent.getBooleanExtra("AIR", false);
        boolean road = intent.getBooleanExtra("ROAD", false);

        //Fields that will change depending on the shipping type
        TextView tvDeparture = findViewById(R.id.tvDeparture);
        EditText etDeparture = findViewById(R.id.etDeparture);

        TextView tvArrival = findViewById(R.id.tvArrival);
        EditText etArrival = findViewById(R.id.etArrival);

        TextView tvBillNumber = findViewById(R.id.tvBillNumber);
        EditText etBillNumber = findViewById(R.id.etBillNumber);

        //Fields that will show when Air is selected
        TextView tvIataCode = findViewById(R.id.tvIataCode);
        EditText etIataCode = findViewById(R.id.etIataCode);

        //Fields that will show when Maritime is selected
        TextView tvVessel = findViewById(R.id.tvVesselName);
        EditText etVessel = findViewById(R.id.etVessel);

        TextView tvVoyage = findViewById(R.id.tvVoyageNumber);
        EditText etVoyage = findViewById(R.id.etVoyageNumber);

        TextView tvSailingDate = findViewById(R.id.tvSailingDate);
        EditText etSailingDate = findViewById(R.id.etSailingDate);

        TextView tvContainerNumber = findViewById(R.id.tvContainerNumber);
        EditText etContainerNumber = findViewById(R.id.etContainerNumber);

        TextView tvContainerType = findViewById(R.id.tvContainerType);
        Spinner dropdown = findViewById(R.id.spContainerType);

        if (maritime) {
            //Fields that will change depending on the shipping type
            tvDeparture.setText("Port of Loading");
            etDeparture.setHint("Port");

            tvArrival.setText("Port of discharge");
            etArrival.setHint("Port");

            tvBillNumber.setText("Bill of Lading\n(BL) number");
            etBillNumber.setHint("Bill of Lading");

            //Fields that will show when Air is selected
            tvIataCode.setVisibility(View.GONE);
            etIataCode.setVisibility(View.GONE);

            //Fields that will show when Maritime is selected
            tvVessel.setVisibility(View.VISIBLE);
            etVessel.setVisibility(View.VISIBLE);

            tvVoyage.setVisibility(View.VISIBLE);
            etVoyage.setVisibility(View.VISIBLE);

            tvSailingDate.setVisibility(View.VISIBLE);
            etSailingDate.setVisibility(View.VISIBLE);

            tvContainerNumber.setVisibility(View.VISIBLE);
            etContainerNumber.setVisibility(View.VISIBLE);

            tvContainerType.setVisibility(View.VISIBLE);
            dropdown.setVisibility(View.VISIBLE);
        }

        else if (air) {
            //Fields that will change depending on the shipping type
            tvDeparture.setText("Departure Airport");
            etDeparture.setHint("Airport");

            tvArrival.setText("Arrival Airport");
            etArrival.setHint("Airport");

            tvBillNumber.setText("Airway Bill\n(AWB) number");
            etBillNumber.setHint("Airway Bill");

            //Fields that will show when Air is selected
            tvIataCode.setVisibility(View.VISIBLE);
            etIataCode.setVisibility(View.VISIBLE);

            //Fields that will show when Maritime is selected
            tvVessel.setVisibility(View.GONE);
            etVessel.setVisibility(View.GONE);

            tvVoyage.setVisibility(View.GONE);
            etVoyage.setVisibility(View.GONE);

            tvSailingDate.setVisibility(View.GONE);
            etSailingDate.setVisibility(View.GONE);

            tvContainerNumber.setVisibility(View.GONE);
            etContainerNumber.setVisibility(View.GONE);

            tvContainerType.setVisibility(View.GONE);
            dropdown.setVisibility(View.GONE);
        }
        else if (road) {
            //Fields that will change depending on the shipping type
            tvDeparture.setText("Port of Loading/\nDeparture Airport");
            etDeparture.setHint("Port / Airport");

            tvArrival.setText("Port of Discharge/\nArrival Airport");
            etArrival.setHint("Port / Airport");

            //Fields that will show when Air is selected
            tvIataCode.setVisibility(View.VISIBLE);
            etIataCode.setVisibility(View.VISIBLE);

            //Fields that will show when Maritime is selected
            tvVessel.setVisibility(View.VISIBLE);
            etVessel.setVisibility(View.VISIBLE);

            tvVoyage.setVisibility(View.VISIBLE);
            etVoyage.setVisibility(View.VISIBLE);

            tvSailingDate.setVisibility(View.VISIBLE);
            etSailingDate.setVisibility(View.VISIBLE);

            tvContainerNumber.setVisibility(View.VISIBLE);
            etContainerNumber.setVisibility(View.VISIBLE);

            tvContainerType.setVisibility(View.VISIBLE);
            dropdown.setVisibility(View.VISIBLE);
        }



        EditText etParty = findViewById(R.id.etParty);
        TextView tvParty = findViewById(R.id.tvParty);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {

                    etParty.setVisibility(View.VISIBLE);
                    tvParty.setVisibility(View.VISIBLE);

                }
                else
                {

                    etParty.setVisibility(View.GONE);
                    tvParty.setVisibility(View.GONE);

                }
            }
        });

        //get the spinner from the xml.
        //Spinner dropdown = findViewById(R.id.spContainerType);
        //create a list of items for the spinner.
        String[] items = new String[]{"40 Dry", "20 Dry", "40 RF", "20 RF", "40 OT", "20 OT", "40 Flat", "20 Flat"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
    }
}