package com.pjatk.pam_fitapp.ui.fitQuiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.pjatk.pam_fitapp.R;

import java.util.Locale;

public class fitQuizFragment extends Fragment {
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private fitQuiz quiz;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_fitquiz, container, false);

        questionTextView = view.findViewById(R.id.questionTextView);
        optionsRadioGroup = view.findViewById(R.id.optionsRadioGroup);
        submitButton = view.findViewById(R.id.submitButton);

        quiz = new fitQuiz();

        displayQuestion(view);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedOptionRadioButton = view.findViewById(selectedOptionId);
                    int selectedOption = optionsRadioGroup.indexOfChild(selectedOptionRadioButton) + 1;
                    quiz.answerQuestion(selectedOption);

                    if (quiz.isQuizFinished()) {
                        showQuizResults();
                    } else {
                        displayQuestion(view);
                    }
                }
            }
        });

        return view;
    }

    private void displayQuestion(View view) {
        fitQuestion currentQuestion = quiz.getCurrentQuestion();
        questionTextView.setText(currentQuestion.getQuestionName());
        RadioButton[] optionRadioButtons = new RadioButton[4];
        optionRadioButtons[0] = view.findViewById(R.id.option1RadioButton);
        optionRadioButtons[1] = view.findViewById(R.id.option2RadioButton);
        optionRadioButtons[2] = view.findViewById(R.id.option3RadioButton);
        optionRadioButtons[3] = view.findViewById(R.id.option4RadioButton);
        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i].setText(currentQuestion.getOptions()[i]);
        }
        optionsRadioGroup.clearCheck();
    }

    private void showQuizResults() {
        int correctAnswers = quiz.getCorrectAnswers();
        int totalQuestions = quiz.getTotalQuestions();
        double quizPercentage = quiz.getQuizPercentage();
        String results = String.format(Locale.getDefault(), "Wynik: %d/%d (%.2f%%)", correctAnswers, totalQuestions, quizPercentage);
        questionTextView.setText(results);
        optionsRadioGroup.setVisibility(View.GONE);
        submitButton.setEnabled(false);
    }
}
