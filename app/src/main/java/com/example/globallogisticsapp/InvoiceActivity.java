package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Collections;

public class InvoiceActivity extends AppCompatActivity {

    Gson gson = new Gson();

    private String json;
    private String shippingType;
    private ShippingManifest data;
    private CostCalculator costs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        Intent intent = getIntent();
        json = intent.getStringExtra("JSON");
        data = (ShippingManifest) intent.getSerializableExtra("JSON_DATA");
        shippingType = intent.getStringExtra("SHIPPING_TYPE");
        String output = intent.getStringExtra("OUTPUT");
        costs = (CostCalculator) intent.getSerializableExtra("COSTS");

        ListView listviewInvoice = findViewById(R.id.listviewInvoice);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Collections.singletonList(output));

        listviewInvoice.setAdapter(adapter);

        //Set the respective Cost text views (including rebate) and calculate and display the total.
        //TO DO . . .
        String text = "Rebate: $" + costs.getRebate();
        TextView rebate = findViewById(R.id.tvRebate2);
        rebate.setText(text);

        text = "Customs: $" + costs.getCustomsCost();
        TextView customs = findViewById(R.id.tvCustomsCost);
        customs.setText(text);

        text = "Transport: $" + costs.getTransportCost();
        TextView transport = findViewById(R.id.tvTransportCost);
        transport.setText(text);

        text = "Transport: $" + costs.getTransportManpowerCost() + "\nManpower";
        TextView transportMP = findViewById(R.id.tvTransportMPCost);
        transportMP.setText(text);

        text = "Discharge: $" + costs.getDischargeCost();
        TextView discharge = findViewById(R.id.tvDischargeCost);
        discharge.setText(text);

        text = "Discharge: $" + costs.getDischargeManpowerCost() + "\nManpower";
        TextView dischargeMP = findViewById(R.id.tvDischargeMPCost);
        dischargeMP.setText(text);

        text = "Loading: $" + costs.getLoadingCost();
        TextView loading = findViewById(R.id.tvLoadingCost);
        loading.setText(text);

        text = "Loading: $" + costs.getLoadingManpowerCost() + "\nManpower";
        TextView loadingMP = findViewById(R.id.tvLoadingMPCost);
        loadingMP.setText(text);

        text = "Warehousing: $" + costs.getWarehousingCost();
        TextView warehousing = findViewById(R.id.tvWarehousingCost);
        warehousing.setText(text);

        text = "Warehousing: $" + costs.getWarehousingManpowerCost() + "\nManpower";
        TextView warehousingMP = findViewById(R.id.tvWarehousingMPCost);
        warehousingMP.setText(text);

        text = "Demurrage: $" + costs.getDemurrageCost();
        TextView demurrage = findViewById(R.id.tvDemurrageCost);
        demurrage.setText(text);

        text = "Detention: $" + costs.getDetentionCost();
        TextView detention = findViewById(R.id.tvDetentionCost);
        detention.setText(text);

        text = "Tariff: $" + costs.getTariffCost();
        TextView tariff = findViewById(R.id.tvTariff);
        tariff.setText(text);

        costs.setTotal();
        text = "Total: $" + costs.getTotal();
        TextView total = findViewById(R.id.tvTotal);
        total.setText(text);



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
        intent.putExtra("COSTS",costs);
        startActivity(intent);
    }
}