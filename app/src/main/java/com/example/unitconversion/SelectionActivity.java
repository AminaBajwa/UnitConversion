package com.example.unitconversion;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SelectionActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        preferences = getPreferences(MODE_PRIVATE);

        Button buttonSelectConversion = findViewById(R.id.buttonSelectConversion);
        buttonSelectConversion.setOnClickListener(v -> {
            int conversionType = getConversionType();
            saveConversionType(conversionType);

            Intent intent = new Intent(SelectionActivity.this, ConversionActivity.class);
            intent.putExtra("conversionType", conversionType);
            startActivity(intent);
        });
    }

    private int getConversionType() {
        RadioGroup radioGroupConversionType = findViewById(R.id.radioGroupConversionType);
        View radioButton = radioGroupConversionType.findViewById(radioGroupConversionType.getCheckedRadioButtonId());

        // Get the tag value of the selected radio button
        if (radioButton != null) {
            String tag = (String) radioButton.getTag();
            if (tag != null) {
                return Integer.parseInt(tag);
            }
        }

        // Default to Pound to Kilogram if no valid conversion type is found
        return 0;
    }

    private void saveConversionType(int conversionType) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("conversionType", conversionType);
        editor.apply();
    }
}
