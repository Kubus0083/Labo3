package com.example.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView textViewSummaryCustomer = findViewById(R.id.textViewSummaryCustomer);
        TextView textViewSummarySize = findViewById(R.id.textViewSummarySize);
        TextView textViewSummaryCheese = findViewById(R.id.textViewSummaryCheese);
        Button buttonBack = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        if (intent != null) {
            String customerName = intent.getStringExtra("CUSTOMER_NAME");
            String pizzaSize = intent.getStringExtra("PIZZA_SIZE");
            boolean hasExtraCheese = intent.getBooleanExtra("EXTRA_CHEESE", false);

            textViewSummaryCustomer.setText("Klient: " + customerName);
            textViewSummarySize.setText("Rozmiar: " + pizzaSize);
            textViewSummaryCheese.setText("Dodatkowy ser: " + (hasExtraCheese ? "Tak" : "Nie"));
        }

        buttonBack.setOnClickListener(v -> finish());
    }
}
