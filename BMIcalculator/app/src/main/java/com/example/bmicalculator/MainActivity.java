package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText weightEditNumber;
    private EditText heightEditNumber;
    private TextView bmiTextView;
    private double bmi = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditNumber = findViewById(R.id.weightTextNumber);
        heightEditNumber = findViewById(R.id.heightTextNumber);
        bmiTextView = findViewById(R.id.bmiTextView);
        calculateButtonListener();
    }

    private double calculateBMI(double weight, double height){
        return weight/(height*height);
    }
    public void calculateButtonListener(){
        Button button = findViewById(R.id.calculateBMIButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String heightString = heightEditNumber.getText().toString();
                String weightString = weightEditNumber.getText().toString();
                Double height = Double.parseDouble(heightString)/100;
                Double weight = Double.parseDouble(weightString);
                bmi = calculateBMI(weight, height);
                DecimalFormat df = new DecimalFormat("#.#");
                bmiTextView.setText(df.format(bmi));
            }
        });
    }
}