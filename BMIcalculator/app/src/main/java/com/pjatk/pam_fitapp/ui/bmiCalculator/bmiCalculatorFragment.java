package com.pjatk.pam_fitapp.ui.bmiCalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pjatk.pam_fitapp.R;

import java.text.DecimalFormat;

public class bmiCalculatorFragment extends Fragment {
    private EditText heightEditNumber;
    private EditText weightEditNumber;
    private TextView bmiResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_bmicalculatorfragment, container, false);
        heightEditNumber = view.findViewById(R.id.heightTextNumber);
        weightEditNumber = view.findViewById(R.id.weightTextNumber);
        bmiResult = view.findViewById(R.id.text_bmi);
        Button bmiCalculateButton = view.findViewById(R.id.calculateBmiButton);

        bmiCalculateButton.setOnClickListener(bmiCalculateListener);

        return view;
    }

    private void calculateBmi(float weight, float height){
        float bmi = weight / (height * height);
        DecimalFormat df = new DecimalFormat("#.#");
        String result = "BMI: " + df.format(bmi);

        bmiResult.setText(result);
    }

    private final View.OnClickListener bmiCalculateListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            String weight = weightEditNumber.getText().toString();
            String height = heightEditNumber.getText().toString();

            if(weight.isEmpty() || height.isEmpty())
                bmiResult.setText("Provide correct data");
            else
                calculateBmi(Float.parseFloat(weight), Float.parseFloat(height)/100);
        }
    };


}
