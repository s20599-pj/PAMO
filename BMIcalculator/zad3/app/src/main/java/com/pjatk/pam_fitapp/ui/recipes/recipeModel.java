package com.pjatk.pam_fitapp.ui.recipes;

public class recipeModel {
    private String title;
    private String[] ingredients;
    private String[] instructions;

    public recipeModel(String title, String[] ingredients, String[] instructions) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }
}
