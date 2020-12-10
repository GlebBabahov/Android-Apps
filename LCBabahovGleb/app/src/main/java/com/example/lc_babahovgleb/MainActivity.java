package com.example.lc_babahovgleb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    private Integer amount;
    private Integer term;
    private Double interest;
    private String[] rates;
    private EditText editTextLoanAmount;
    private EditText editTextLoanTerm;
    private RadioGroup radioGroup;

    enum TypeOfTerm {
        MONTH,
        YEAR;
    }
    private TypeOfTerm termType = TypeOfTerm.MONTH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLoanAmount = findViewById(R.id.editTextLoanAmount);
        editTextLoanTerm = findViewById(R.id.editTextLoanTerm);
        radioGroup = findViewById(R.id.radioGroup);



        rates = getResources().getStringArray(R.array.rates);


        editTextLoanAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                amount = Integer.parseInt(s.toString());
            }
        });

        editTextLoanTerm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (termType == TypeOfTerm.MONTH) {
                    term = Integer.parseInt(s.toString());
                } else {
                    term = Integer.parseInt(s.toString()) / 12;
                }
            }
        });

        Spinner rateSpinner = findViewById(R.id.spinnerRates);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rates);
        rateSpinner.setAdapter(adapter);
        rateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                interest = Double.parseDouble(rates[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monthlyPayment;
                monthlyPayment = amount * interest * (1 + interest) ^ term / ( (1 + interest) ^ term) - 1 );
        
            }
        });
    }

    public void onSelect(View view) {
        RadioButton b = findViewById(radioGroup.getCheckedRadioButtonId());
        if (b.getId() == R.id.radioButtonYears) {
            termType = TypeOfTerm.YEAR;
        } else {
            termType = TypeOfTerm.MONTH;
        }
    }
}