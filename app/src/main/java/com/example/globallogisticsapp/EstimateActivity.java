package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Collections;

public class EstimateActivity extends AppCompatActivity {

    Gson gson = new Gson();

    private String json;
    private String output;
    private String shippingType;
    private ShippingManifest data;
    private ListView listviewEstimate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate);

        Intent intent = getIntent();
        json = intent.getStringExtra("JSON");
        data = (ShippingManifest) intent.getSerializableExtra("JSON_DATA");
        shippingType = intent.getStringExtra("SHIPPING_TYPE");

        output = json;
        output = output.replace("{","");
        output = output.replace("}","");
        output = output.replace("\",\"","\"\n\n\"");
        output = output.replace("\"","");
        output = output.replace(":",": ");

        /******************************************************************
         * The editing of the json output in the switch statement should
         * be moved to a background thread, possibly done before the
         * estimate and invoice activities.
         ******************************************************************/

        //shippingType = "Maritime"
        switch (shippingType) {
            case "Maritime":

                //Fields that will change depending on the shipping type
                output = output.replace("Departure", "Port of Loading");

                output = output.replace("Arrival:", "Port of discharge:");

                output = output.replace("BillNumber", "Bill of Lading");

                //Fields that will show when Air is selected
                output = output.replace("IataCode:\n", "");

                //Fields that will show when Maritime is selected
                output = output.replace("SailingDate", "Sailing Date");

                output = output.replace("ContainerNumber", "Container Number");

                output = output.replace("ContainerType", "Container Type");

                output = output.replace("VoyageNumber","Voyage Number");

                //Fields that will show when Road is selected
                output = output.replace("Truck:\n", "");

                output = output.replace("GrossWeight:\n", "");

                output = output.replace("LicenceID:\n", "");
                break;

            //shippingType = "Air"
            case "Air":

                //Fields that will change depending on the shipping type
                output = output.replace("Departure", "Departure Airport");//tvDeparture.setText("Departure Airport");

                output = output.replace("Arrival", "Arrival Airport");//tvArrival.setText("Arrival Airport");

                output = output.replace("BillNumber", "Airway Bill(AWB)");//tvBillNumber.setText("Airway Bill\n(AWB) number");

                //Fields that will show when Air is selected
                output = output.replace("IataCode","Iata Code");//tvIataCode.setVisibility(View.VISIBLE);

                //Fields that will show when Maritime is selected
                output = output.replace("Vessel:\n","");//tvVessel.setVisibility(View.GONE);

                output = output.replace("VoyageNumber:\n","");//tvVoyage.setVisibility(View.GONE);

                output = output.replace("SailingDate:\n","");//tvSailingDate.setVisibility(View.GONE);

                output = output.replace("ContainerNumber:\n","");//tvContainerNumber.setVisibility(View.GONE);

                output = output.replace("ContainerType:40 Dry\n","");//tvContainerType.setVisibility(View.GONE);

                //Fields that will show when Road is selected
                output = output.replace("Truck:\n", "");

                output = output.replace("GrossWeight:\n", "");

                output = output.replace("LicenceID:\n", "");
                break;
            //shippingType = "Road"
            case "Road":

                //Fields that will change depending on the shipping type
                output = output.replace("Departure:\n","");//tvDeparture.setVisibility(View.GONE);

                output = output.replace("Arrival:\n","");//tvArrival.setVisibility(View.GONE);

                output = output.replace("BillNumber","Bill of Lading");//tvBillNumber.setText("Bill of Lading\n(BL) number");

                output = output.replace("ShipperName:\n","");//tvShipperName.setVisibility(View.GONE);

                output = output.replace("ShipperAddress:\n","");//tvShipperAddress.setVisibility(View.GONE);

                output = output.replace("ShipperAccount:\n","");//tvShipperAccount.setVisibility(View.GONE);

                output = output.replace("Carrier:\n","");//tvCarrier.setVisibility(View.GONE);

                output = output.replace("CarrierAgentName:\n","");//tvAgentName.setVisibility(View.GONE);

                output = output.replace("CarrierAgentAddress:\n","");//tvAgentAddress.setVisibility(View.GONE);

                //Fields that will show when Air is selected
                output = output.replace("IataCode:\n","");//tvIataCode.setVisibility(View.GONE);

                //Fields that will show when Maritime is selected
                output = output.replace("Vessel:\n","");//tvVessel.setVisibility(View.GONE);

                output = output.replace("VoyageNumber:\n","");//tvVoyage.setVisibility(View.GONE);

                output = output.replace("SailingDate:\n","");//tvSailingDate.setVisibility(View.GONE);

                output = output.replace("ContainerNumber","Container Number");//tvContainerNumber.setVisibility(View.VISIBLE);

                output = output.replace("ContainerType","Container Type");//tvContainerType.setVisibility(View.VISIBLE);

                //Fields that will show when Road is selected
                output = output.replace("TruckID","Truck ID");//tvTruckID.setVisibility(View.VISIBLE);

                output = output.replace("GrossWeight","Gross Weight");//tvGrossWeight.setVisibility(View.VISIBLE);

                output = output.replace("LicenceID","Licence ID");//tvLicence.setVisibility(View.VISIBLE);
                break;
        }

        //Log
        //Log.d(this.getLocalClassName(), "String version: " + output);

        /*************************************************************
         * End of editing block.
         ************************************************************/

        listviewEstimate = findViewById(R.id.listviewEstimate);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Collections.singletonList(output));

        listviewEstimate.setAdapter(adapter);

        Button invoice = findViewById(R.id.bToInvoice);
        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInvoice(v);
            }
        });

        Button toServices = findViewById(R.id.bBackToServices);
        toServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openServices(v);
            }
        });
    }

    public void openInvoice(View view) {
        Intent intent = new Intent(this, InvoiceActivity.class);

        intent.putExtra("JSON_DATA", data);
        intent.putExtra("JSON", json);
        intent.putExtra("OUTPUT", output);
        intent.putExtra("SHIPPING_TYPE",shippingType);
        startActivity(intent);
    }

    public void openServices(View view) {
        Intent intent = new Intent(this, ServicesActivity.class);
        intent.putExtra("JSON_DATA", data);
        intent.putExtra("JSON", json);
        intent.putExtra("SHIPPING_TYPE", shippingType);
        startActivity(intent);
    }
}