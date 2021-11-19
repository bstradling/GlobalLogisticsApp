package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.Collections;

public class InvoiceActivity extends AppCompatActivity {

    Gson gson = new Gson();

    private String json;
    private String shippingType;
    private ShippingManifest data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        Intent intent = getIntent();
        json = intent.getStringExtra("JSON");
        data = (ShippingManifest) intent.getSerializableExtra("JSON_DATA");
        shippingType = intent.getStringExtra("SHIPPING_TYPE");
        String output = intent.getStringExtra("OUTPUT");

        ListView listviewInvoice = findViewById(R.id.listviewInvoice);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Collections.singletonList(output));

        listviewInvoice.setAdapter(adapter);

        Button estimate = findViewById(R.id.bBackToEstimate);
        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEstimate(v);
            }
        });
    }

    public void openEstimate(View view) {
        Intent intent = new Intent(this, EstimateActivity.class);

        intent.putExtra("JSON_DATA", data);
        intent.putExtra("JSON", json);
        intent.putExtra("SHIPPING_TYPE",shippingType);
        startActivity(intent);
    }
}