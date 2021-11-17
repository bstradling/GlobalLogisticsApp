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
    private ShippingManifest data;
    private ListView listviewEstimate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate);

        Intent intent = getIntent();
        json = intent.getStringExtra("JSON");
        data = (ShippingManifest) intent.getSerializableExtra("JSON_DATA");

        String output = json;
        output = output.replace("{","");
        output = output.replace("}","");
        output = output.replace("\",\"","\"\n\"");

        //Log
        //Log.d(this.getLocalClassName(), "String version: " + output);

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
    }

    public void openInvoice(View view) {
        Intent intent = new Intent(this, InvoiceActivity.class);

        startActivity(intent);
    }
}