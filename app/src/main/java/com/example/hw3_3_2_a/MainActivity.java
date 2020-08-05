package com.example.hw3_3_2_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        final Spinner languageSpinner = findViewById(R.id.languageSpinner);
        final Button okBtn = findViewById(R.id.okBtn);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.languages);
                language = languages[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale(language);
                Configuration configuration = new Configuration();
                configuration.setLocale(locale);
                getResources().updateConfiguration(configuration,
                        getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }
}