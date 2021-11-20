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

        output = output.replace("AccountInfo:","Account Info:");
        output = output.replace("AccountNumber:","Account Number:");
        output = output.replace("ArrivalDate:","Arrival Date:");
        output = output.replace("CarrierAgentAddress:","Carrier Agent Address:");
        output = output.replace("CarrierAgentName:","Carrier Agent Name:");
        output = output.replace("Consignee","Consignee ");
        output = output.replace("CustomsClearance:","Customs Clearance:");
        output = output.replace("Delivery:","Place of Delivery:");
        output = output.replace("DepartureDate:","Departure Date:");
        output = output.replace("DischargingAdditionalManpower:","(Discharging)\nAdditional Manpower:");
        output = output.replace("LoadingAdditionalManpower:","(Loading)\nAdditional Manpower:");
        output = output.replace("NotifyParty:","Notify Party:");
        output = output.replace("NumberofPieces:","Number of Pieces:");
        output = output.replace("Reception:","Place of Reception:");
        output = output.replace("Shipper","Shipper ");
        output = output.replace("ShippingType:","Shipping Type:");
        output = output.replace("TransportAdditionalManpower:","(Transport)\nAdditional Manpower:");
        output = output.replace("WarehousingAdditionalManpower:","(Warehousing)\nAdditional Manpower:");

        //shippingType = "Maritime"
        switch (shippingType) {
            case "Maritime":

                //Fields that will change depending on the shipping type
                output = output.replace("Departure:", "Port of Loading:");

                output = output.replace("Arrival:", "Port of discharge:");

                output = output.replace("BillNumber", "Bill of Lading");

                //Fields that will show when Air is selected
                output = output.replace("IataCode: \n\n", "");

                //Fields that will show when Maritime is selected
                output = output.replace("SailingDate", "Sailing Date");

                output = output.replace("ContainerNumber", "Container Number");

                output = output.replace("ContainerType", "Container Type");

                output = output.replace("VoyageNumber","Voyage Number");

                //Fields that will show when Road is selected
                output = output.replace("Truck: \n\n", "");

                output = output.replace("GrossWeight: \n\n", "");

                output = output.replace("LicenceID: \n\n", "");
                break;

            //shippingType = "Air"
            case "Air":

                //Fields that will change depending on the shipping type
                output = output.replace("Departure:", "Departure Airport:");

                output = output.replace("Arrival:", "Arrival Airport:");

                output = output.replace("BillNumber", "Airway Bill(AWB)");

                //Fields that will show when Air is selected
                output = output.replace("IataCode","Iata Code");

                //Fields that will show when Maritime is selected
                output = output.replace("Vessel: \n\n","");

                output = output.replace("VoyageNumber: \n\n","");

                output = output.replace("SailingDate: \n\n","");

                output = output.replace("ContainerNumber: \n\n","");

                output = output.replace("ContainerType:40 Dry\n\n","");

                //Fields that will show when Road is selected
                output = output.replace("Truck: \n\n", "");

                output = output.replace("GrossWeight: \n\n", "");

                output = output.replace("LicenceID: \n\n", "");
                break;
            //shippingType = "Road"
            case "Road":

                //Fields that will change depending on the shipping type
                output = output.replace("Departure: \n\n","");

                output = output.replace("Arrival: \n\n","");

                output = output.replace("BillNumber","Bill of Lading");

                output = output.replace("Shipper Name: \n\n","");

                output = output.replace("Shipper Address: \n\n","");

                output = output.replace("Shipper Account: \n\n","");

                output = output.replace("Carrier: \n\n","");

                output = output.replace("Carrier Agent Name: \n\n","");

                output = output.replace("Carrier Agent Address: \n\n","");

                //Fields that will show when Air is selected
                output = output.replace("IataCode: \n\n","");

                //Fields that will show when Maritime is selected
                output = output.replace("Vessel: \n\n","");

                output = output.replace("VoyageNumber: \n\n","");

                output = output.replace("SailingDate: \n\n","");

                output = output.replace("ContainerNumber","Container Number");

                output = output.replace("ContainerType","Container Type");

                //Fields that will show when Road is selected
                output = output.replace("Truck","Truck ID");

                output = output.replace("GrossWeight","Gross Weight");

                output = output.replace("LicenceID","Licence ID");
                break;
        }

        //Log
        //Log.d(this.getLocalClassName(), "String version: " + output);

        /*************************************************************
         * End of editing block.
         ************************************************************/

        ListView listviewEstimate = findViewById(R.id.listviewEstimate);

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