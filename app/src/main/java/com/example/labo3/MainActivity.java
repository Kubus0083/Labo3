package com.example.labo3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCustomerName;
    private RadioGroup radioGroupSize;
    private CheckBox checkBoxExtraCheese;
    private Button buttonGoToSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCustomerName = findViewById(R.id.editTextCustomerName);
        radioGroupSize = findViewById(R.id.radioGroupSize);
        checkBoxExtraCheese = findViewById(R.id.checkBoxExtraCheese);
        buttonGoToSummary = findViewById(R.id.buttonGoToSummary);

        buttonGoToSummary.setOnClickListener(v -> {
            String customerName = editTextCustomerName.getText().toString().trim();

            if (customerName.isEmpty()) {
                editTextCustomerName.setError("Podaj nazwę klienta!");
                return;
            }

            int selectedId = radioGroupSize.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);
            String pizzaSize = selectedRadioButton.getText().toString();

            boolean hasExtraCheese = checkBoxExtraCheese.isChecked();

            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            intent.putExtra("CUSTOMER_NAME", customerName);
            intent.putExtra("PIZZA_SIZE", pizzaSize);
            intent.putExtra("EXTRA_CHEESE", hasExtraCheese);
            startActivity(intent);
        });
    }
}
