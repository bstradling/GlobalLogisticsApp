package com.example.globallogisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ManifestDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manifest_data);

        EditText etDate = findViewById(R.id.etSailingDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        etDate.setHint(dateFormat.format(new Date()));

        EditText etConsignee = findViewById(R.id.etConsignee);
        TextView tvConsignee = findViewById(R.id.tvConsignee);

        EditText etParty = findViewById(R.id.etParty);
        TextView tvParty = findViewById(R.id.tvParty);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    etConsignee.setVisibility(View.VISIBLE);
                    tvConsignee.setVisibility(View.VISIBLE);

                    etParty.setVisibility(View.VISIBLE);
                    tvParty.setVisibility(View.VISIBLE);

                }
                else
                {
                    etConsignee.setVisibility(View.VISIBLE);
                    tvConsignee.setVisibility(View.VISIBLE);

                    etParty.setVisibility(View.GONE);
                    tvParty.setVisibility(View.GONE);

                }
            }
        });
    }
}