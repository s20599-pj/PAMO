package com.pjatk.pam_fitapp.ui.kcalCalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pjatk.pam_fitapp.R;

import java.text.DecimalFormat;

public class kcalCalculatorFragment extends Fragment {
    private EditText heightEditNumber;
    private EditText weightEditNumber;
    private EditText ageEditNumber;
    private Spinner genderResult;
    private TextView kcalResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_kcalcalculator, container, false);
        heightEditNumber = view.findViewById(R.id.kcal_heightTextNumber);
        weightEditNumber = view.findViewById(R.id.kcal_weightTextNumber);
        ageEditNumber = view.findViewById(R.id.kcal_ageTextNumber);
        genderResult = view.findViewById(R.id.kcal_gender);
        kcalResult = view.findViewById(R.id.text_kcalResults);
        Button kcalCalculateButton = view.findViewById(R.id.calculateKcalResult);

        kcalCalculateButton.setOnClickListener(kcalCalculateListener);

        return view;
    }

    private void calculateKcal(float weight, float height, float age, Gender gender){
        float kcal = 0.0F;
        if (gender == Gender.MALE) {
            kcal = 66.473F + (13.7516F * weight) + (5.0033F * height) - (6.755F * age);
        }
        else{
            kcal = 655.0955F + (9.5634F * weight) + (1.8496F * height) - (4.6756F * age);
        }
        DecimalFormat df = new DecimalFormat("#");
        String result = "Daily Kcal: " + df.format(kcal);

        kcalResult.setText(result);
    }

    private final View.OnClickListener kcalCalculateListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            String weight = weightEditNumber.getText().toString();
            String height = heightEditNumber.getText().toString();
            String age = ageEditNumber.getText().toString();
            Gender gender = Gender.valueOf(genderResult.getSelectedItem().toString());

            if(weight.isEmpty() || height.isEmpty() || age.isEmpty())
                kcalResult.setText("Provide correct data");
            else
                calculateKcal(Float.parseFloat(weight), Float.parseFloat(height), Float.parseFloat(age), gender);
        }
    };

    public enum Gender{
        MALE,
        FEMALE
    }
}
