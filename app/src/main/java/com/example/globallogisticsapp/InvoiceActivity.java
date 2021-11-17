package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        Button estimate = findViewById(R.id.bBacktoEstimate);
        estimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEstimate(v);
            }
        });
    }

    public void openEstimate(View view) {
        Intent intent = new Intent(this, EstimateActivity.class);

        startActivity(intent);
    }
}