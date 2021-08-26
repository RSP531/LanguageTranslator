package com.example.languagetranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView messageView;
    Button btnHindi, btnEnglish, btnSpanish, toggleLanguage;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referencing the text and button views
        messageView = (TextView) findViewById(R.id.textView);
        btnHindi = findViewById(R.id.btnHindi);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnSpanish = findViewById(R.id.btnSpanish);
        toggleLanguage = findViewById(R.id.toggleLanguage);

        // setting up on click listener event over the button
        // in order to change the language with the help of
        // LocaleHelper class
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "en");
                resources = context.getResources();
                messageView.setText(resources.getString(R.string.language));
            }
        });

        btnHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "hi");
                resources = context.getResources();
                messageView.setText(resources.getString(R.string.language));
            }
        });


        btnSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = LocaleHelper.setLocale(MainActivity.this, "es");
                resources = context.getResources();
                messageView.setText(resources.getString(R.string.language));
            }
        });

        toggleLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] languages = {"hi","es","en"};
                Log.d("bleh","This isn't a test!!!!!");
                Log.d("bleh",messageView.getText().toString());
                context = LocaleHelper.setLocale(MainActivity.this, "es");
                resources = context.getResources();
                messageView.setText(resources.getString(R.string.language));
            }
        });
    }
}
