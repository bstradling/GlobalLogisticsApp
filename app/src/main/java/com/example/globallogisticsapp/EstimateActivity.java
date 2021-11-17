package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EstimateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate);

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