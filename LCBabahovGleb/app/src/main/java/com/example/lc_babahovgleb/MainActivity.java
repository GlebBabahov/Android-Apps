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
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Integer amount;
    private Integer term;
    private double interest;
    private String[] rates;
    private EditText editTextLoanAmount;
    private EditText editTextLoanTerm;
    private RadioGroup radioGroup;
    private TextView textViewMonthlyPayment;
    private TextView textViewInterestPaid;
    private TextView textView;
    private boolean isTermMonth = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLoanAmount = findViewById(R.id.editTextLoanAmount);
        editTextLoanTerm = findViewById(R.id.editTextLoanTerm);
        radioGroup = findViewById(R.id.radioGroup);
        textViewMonthlyPayment = findViewById(R.id.textViewMonthlyPayments);
        textViewInterestPaid = findViewById(R.id.textViewInterestPaid);

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
                try {
                    amount = Integer.parseInt(s.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        editTextLoanTerm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    term = Integer.parseInt(s.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Spinner rateSpinner = findViewById(R.id.spinnerRates);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, rates);
        rateSpinner.setAdapter(adapter);
        rateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    String str = rates[position];
                    str = str.replaceAll("\\D*$", "");
                    interest = Double.parseDouble(str) / 1200.0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isTermMonth) {
                        term = Integer.parseInt(editTextLoanTerm.getText().toString());
                    } else {
                        term = Integer.parseInt(editTextLoanTerm.getText().toString()) * 12;
                    }
                    double monthlyPayment = (amount * interest * (Math.pow(1 + interest, term) / (Math.pow(1 + interest, term) - 1)));
                    textViewMonthlyPayment.setText("$" + String.format(Locale.US, "%1.2f", monthlyPayment));
                    textViewInterestPaid.setText("$" + String.format(Locale.US,"%1.2f", ((monthlyPayment * term) - amount)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onSelect(View view) {
        try {
            RadioButton b = findViewById(radioGroup.getCheckedRadioButtonId());
            if (b.getId() == R.id.radioButtonYears) {
                isTermMonth = false;
            } else {
                isTermMonth = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}