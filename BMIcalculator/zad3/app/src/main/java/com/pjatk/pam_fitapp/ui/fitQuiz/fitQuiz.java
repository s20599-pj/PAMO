package com.pjatk.pam_fitapp.ui.fitQuiz;

import java.util.ArrayList;
import java.util.List;

public class fitQuiz {
    private List<fitQuestion> questions;
    private int currentQuestion;
    private int correctAnswers;

    public fitQuiz() {
        this.questions = new ArrayList<>();
        this.currentQuestion = 0;
        this.correctAnswers = 0;
        addQuestions();
    }

    private void addQuestions()
    {
        questions.add(new fitQuestion("Co jest najlepszym źródłem białka?", "Mięso", "Ryby", "Warzywa", "Owoce", 1));
        questions.add(new fitQuestion("Które z poniższych nie jest zdrowym tłuszczem?", "Masło", "Awokado", "Orzechy", "Oliwa z oliwek", 1));
        questions.add(new fitQuestion("Ile wody powinno się pić dziennie?", "1 litr", "2 litry", "3 litry", "4 litry", 2));
        questions.add(new fitQuestion("Które z poniższych jest źródłem węglowodanów złożonych?", "Chleb pełnoziarnisty", "Biały chleb", "Cukier", "Bakłażan", 1));
        questions.add(new fitQuestion("Które z poniższych jest najbogatszym źródłem witaminy C?", "Marchewka", "Pomarańcza", "Banany", "Gruszka", 2));
        questions.add(new fitQuestion("Które z poniższych nie jest źródłem wapnia?", "Mleko", "Ser", "Jogurt", "Kiełbasa", 4));
    }
    public fitQuestion getCurrentQuestion() {
        return questions.get(currentQuestion);
    }

    public void answerQuestion(int selectedOption) {
        if (selectedOption == getCurrentQuestion().getCorrectOption()) {
            correctAnswers++;
        }
        currentQuestion++;
    }

    public boolean isQuizFinished() {
        return currentQuestion == questions.size();
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public double getQuizPercentage() {
        return (double) correctAnswers / questions.size() * 100;
    }
}
