package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ManifestDataActivity extends AppCompatActivity {
    ShippingManifest data = new ShippingManifest();
    Gson gson = new Gson();
    String json;

    String shippingType;

    EditText etDeparture;
    EditText etArrival;
    EditText etBillNumber;
    EditText etShipperName;
    EditText etShipperAddress;
    EditText etShipperAccount;
    EditText etCarrier;
    EditText etAgentName;
    EditText etAgentAddress;
    EditText etIataCode;
    EditText etVessel;
    EditText etVoyage;
    EditText etSailingDate;
    EditText etContainerNumber;

    //ContainerType
    Spinner dropdown;

    EditText etTruckID;
    EditText etGrossWeight;
    EditText etLicence;

    EditText etAccountNumber;
    EditText etAccountInfo;
    EditText etArrivalDate;
    EditText etConsigneeName;
    EditText etConsigneeAddress;
    EditText etConsigneeAccount;
    EditText etDelivery;
    EditText etDepartureDate;
    EditText etDescription;
    EditText etDimensions;
    EditText etParty;
    EditText etNumberofPieces;
    EditText etPackaging;
    EditText etQuality;
    EditText etReception;
    EditText etReference;
    EditText etUnits;
    EditText etVolume;
    EditText etWeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifest_data);
        //Depending on the shipping type selected set the manifest fields may change

        Intent intent = getIntent();
        boolean maritime = intent.getBooleanExtra("MARITIME", false);
        boolean air = intent.getBooleanExtra("AIR", false);
        boolean road = intent.getBooleanExtra("ROAD", false);

        //Fields that will change depending on the shipping type
        TextView tvDeparture = findViewById(R.id.tvDeparture);
        etDeparture = findViewById(R.id.etDeparture);

        TextView tvArrival = findViewById(R.id.tvArrival);
        etArrival = findViewById(R.id.etArrival);

        TextView tvBillNumber = findViewById(R.id.tvBillNumber);
        etBillNumber = findViewById(R.id.etBillNumber);

        etShipperName = findViewById(R.id.etShipperName);
        TextView tvShipperName = findViewById(R.id.tvShipperName);

        etShipperAddress = findViewById(R.id.etShipperAddress);
        TextView tvShipperAddress = findViewById(R.id.tvShipperAddress);

        etShipperAccount = findViewById(R.id.etShipperAccount);
        TextView tvShipperAccount = findViewById(R.id.tvShipperAccount);

        etCarrier = findViewById(R.id.etCarrier);
        TextView tvCarrier = findViewById(R.id.tvCarrier);

        etAgentName = findViewById(R.id.etCarrierAgentName);
        TextView tvAgentName = findViewById(R.id.tvCarrierAgentName);

        etAgentAddress = findViewById(R.id.etCarrierAgentAddress);
        TextView tvAgentAddress = findViewById(R.id.tvCarrierAgentAddress);

        //Fields that will show when Air is selected
        TextView tvIataCode = findViewById(R.id.tvIataCode);
        etIataCode = findViewById(R.id.etIataCode);

        //Fields that will show when Maritime is selected
        TextView tvVessel = findViewById(R.id.tvVesselName);
        etVessel = findViewById(R.id.etVessel);

        TextView tvVoyage = findViewById(R.id.tvVoyageNumber);
        etVoyage = findViewById(R.id.etVoyageNumber);

        TextView tvSailingDate = findViewById(R.id.tvSailingDate);
        etSailingDate = findViewById(R.id.etSailingDate);

        TextView tvContainerNumber = findViewById(R.id.tvContainerNumber);
        etContainerNumber = findViewById(R.id.etContainerNumber);

        TextView tvContainerType = findViewById(R.id.tvContainerType);
        dropdown = findViewById(R.id.spContainerType);

        //Fields that will show when Road is selected
        etTruckID = findViewById(R.id.etTruckID);
        TextView tvTruckID = findViewById(R.id.tvTruckID);

        etGrossWeight = findViewById(R.id.etGrossWeight);
        TextView tvGrossWeight = findViewById(R.id.tvGrossWeight);

        etLicence = findViewById(R.id.etLicenseID);
        TextView tvLicence = findViewById(R.id.tvLicenseID);

        if (maritime) {
            shippingType = "Maritime";
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

            //Fields that will show when Road is selected
            etTruckID.setVisibility(View.GONE);
            tvTruckID.setVisibility(View.GONE);

            etGrossWeight.setVisibility(View.GONE);
            tvGrossWeight.setVisibility(View.GONE);

            etLicence.setVisibility(View.GONE);
            tvLicence.setVisibility(View.GONE);
        }

        else if (air) {
            shippingType = "Air";
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

            //Fields that will show when Road is selected
            etTruckID.setVisibility(View.GONE);
            tvTruckID.setVisibility(View.GONE);

            etGrossWeight.setVisibility(View.GONE);
            tvGrossWeight.setVisibility(View.GONE);

            etLicence.setVisibility(View.GONE);
            tvLicence.setVisibility(View.GONE);
        }
        else if (road) {
            shippingType = "Road";
            //Fields that will change depending on the shipping type
            tvDeparture.setVisibility(View.GONE);
            etDeparture.setVisibility(View.GONE);

            tvArrival.setVisibility(View.GONE);
            etArrival.setVisibility(View.GONE);

            tvBillNumber.setText("Bill of Lading\n(BL) number");
            etBillNumber.setHint("Bill of Lading");

            etShipperName.setVisibility(View.GONE);
            tvShipperName.setVisibility(View.GONE);

            etShipperAddress.setVisibility(View.GONE);
            tvShipperAddress.setVisibility(View.GONE);

            etShipperAccount.setVisibility(View.GONE);
            tvShipperAccount.setVisibility(View.GONE);

            etCarrier.setVisibility(View.GONE);
            tvCarrier.setVisibility(View.GONE);

            etAgentName.setVisibility(View.GONE);
            tvAgentName.setVisibility(View.GONE);

            etAgentAddress.setVisibility(View.GONE);
            tvAgentAddress.setVisibility(View.GONE);

            //Fields that will show when Air is selected
            tvIataCode.setVisibility(View.GONE);
            etIataCode.setVisibility(View.GONE);

            //Fields that will show when Maritime is selected
            tvVessel.setVisibility(View.GONE);
            etVessel.setVisibility(View.GONE);

            tvVoyage.setVisibility(View.GONE);
            etVoyage.setVisibility(View.GONE);

            tvSailingDate.setVisibility(View.GONE);
            etSailingDate.setVisibility(View.GONE);

            tvContainerNumber.setVisibility(View.VISIBLE);
            etContainerNumber.setVisibility(View.VISIBLE);

            tvContainerType.setVisibility(View.VISIBLE);
            dropdown.setVisibility(View.VISIBLE);

            //Fields that will show when Road is selected
            etTruckID.setVisibility(View.VISIBLE);
            tvTruckID.setVisibility(View.VISIBLE);

            etGrossWeight.setVisibility(View.VISIBLE);
            tvGrossWeight.setVisibility(View.VISIBLE);

            etLicence.setVisibility(View.VISIBLE);
            tvLicence.setVisibility(View.VISIBLE);
        }



        etParty = findViewById(R.id.etParty);
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

        etAccountNumber = findViewById(R.id.etAccountNumber);
        etAccountInfo = findViewById(R.id.etAccountingInfo);
        etArrivalDate = findViewById(R.id.etArrivalDate);
        etConsigneeName = findViewById(R.id.etConsigneeName);
        etConsigneeAddress = findViewById(R.id.etConsigneeAddress);
        etConsigneeAccount = findViewById(R.id.etConsigneeAccount);
        etDelivery = findViewById(R.id.etDelivery);
        etDepartureDate = findViewById(R.id.etDepartureDate);
        etDescription = findViewById(R.id.etDescription);
        etDimensions = findViewById(R.id.etDimensions);
        etNumberofPieces = findViewById(R.id.etPieces);
        etPackaging = findViewById(R.id.etPackaging);
        etQuality = findViewById(R.id.etQuality);
        etReception = findViewById(R.id.etReception);
        etReference = findViewById(R.id.etReference);
        etUnits = findViewById(R.id.etUnits);
        etVolume = findViewById(R.id.etVolume);
        etWeight = findViewById(R.id.etWeight);


        Button toServices = (Button) findViewById(R.id.bToServices);
        toServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveManifest();
                openServices(v);
            }
        });
    }

    public void saveManifest() {
        data.setAccountInfo(etAccountInfo.getText().toString());
        data.setAccountNumber(etAccountNumber.getText().toString());
        data.setArrival(etArrival.getText().toString());
        data.setArrivalDate(etArrivalDate.getText().toString());
        data.setCarrier(etCarrier.getText().toString());
        data.setBillNumber(etBillNumber.getText().toString());
        data.setCarrierAgentName(etAgentName.getText().toString());
        data.setCarrierAgentAddress(etAgentAddress.getText().toString());
        data.setConsigneeAccount(etConsigneeAccount.getText().toString());
        data.setConsigneeAddress(etConsigneeAddress.getText().toString());
        data.setConsigneeName(etConsigneeName.getText().toString());
        data.setContainerNumber(etContainerNumber.getText().toString());
        data.setContainerType(dropdown.getSelectedItem().toString());
        data.setDelivery(etDelivery.getText().toString());
        data.setDeparture(etDeparture.getText().toString());
        data.setDepartureDate(etDepartureDate.getText().toString());
        data.setDescription(etDescription.getText().toString());
        data.setDimensions(etDimensions.getText().toString());
        data.setNumberofPieces(etNumberofPieces.getText().toString());
        data.setPackaging(etPackaging.getText().toString());
        data.setQuality(etQuality.getText().toString());
        data.setReception(etReception.getText().toString());
        data.setReference(etReference.getText().toString());
        data.setSailingDate(etSailingDate.getText().toString());
        data.setShipperAccount(etShipperAccount.getText().toString());
        data.setShipperAddress(etShipperAddress.getText().toString());
        data.setShipperName(etShipperName.getText().toString());
        data.setShippingType(shippingType);
        data.setTruck(etTruckID.getText().toString());
        data.setUnits(etUnits.getText().toString());
        data.setVessel(etVessel.getText().toString());
        data.setVolume(etVolume.getText().toString());
        data.setVoyageNumber(etVoyage.getText().toString());
        data.setWeight(etWeight.getText().toString());

        json = gson.toJson(data);

        Log.d(this.getLocalClassName(), "Attempting to save JSON data\n" + json);
    }

    public void openServices(View view) {
        //Intent intent = new Intent(this, AdditionalServicesActivity.class);


        //intent.putExtra("JSON_DATA", data);
        //intent.putExtra("JSON", json);

        //startActivity(intent);
    }
}