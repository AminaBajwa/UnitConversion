package com.example.unitconversion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//public class ConversionActivity extends AppCompatActivity {
//    private EditText editTextValue;
//    private TextView textViewResult;
//    private int conversionType;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_conversion);
//
//        editTextValue = findViewById(R.id.editTextValue);
//        textViewResult = findViewById(R.id.textViewResult);
//
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            conversionType = extras.getInt("conversionType");
//        }
//
//        Button buttonConvert = findViewById(R.id.buttonConvert);
//        buttonConvert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                convert();
//            }
//        });
//    }
//
//    private void convert() {
//        double value = Double.parseDouble(editTextValue.getText().toString());
//        double result = 0.0;
//
//        switch (conversionType) {
//            case 0: // Pound to Kilogram
//                result = UnitConverter.poundToKilogram(value);
//                break;
//            case 1: // Kilogram to Pound
//                result = UnitConverter.kilogramToPound(value);
//                break;
//            case 2: // Mile to Kilometer
//                result = UnitConverter.mileToKilometer(value);
//                break;
//            case 3: // Kilometer to Mile
//                result = UnitConverter.kilometerToMile(value);
//                break;
//        }
//
//        textViewResult.setText(String.valueOf(result));
//    }
//}
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConversionActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        preferences = getPreferences(MODE_PRIVATE);
        int conversionType = getIntent().getIntExtra("conversionType", 0);

        EditText editTextValue = findViewById(R.id.editTextValue);
        TextView textViewResult = findViewById(R.id.textViewResult);

        Button buttonConvert = findViewById(R.id.buttonConvert);
        buttonConvert.setOnClickListener(v -> {
            double value = Double.parseDouble(editTextValue.getText().toString());
            double result = performConversion(value, conversionType);
            textViewResult.setText(String.valueOf(result));
        });
    }

    private double performConversion(double value, int conversionType) {
        switch (conversionType) {
            case 0: // Pound to Kilogram
                return value * 0.453592;
            case 1: // Kilogram to Pound
                return value * 2.20462;
            case 2: // Mile to Kilometer
                return value * 1.60934;
            case 3: // Kilometer to Mile
                return value * 0.621371;
            default:
                return 0; // Default to Pound to Kilogram
        }
    }
}
