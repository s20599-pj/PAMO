package com.pjatk.pam_fitapp.ui.recipes;

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
import java.util.ArrayList;
import java.util.List;

public class recipesFragment extends Fragment {

    private TextView recipeText;
    private Spinner recipeName;
    private List<recipeModel> recipeList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        recipeText = view.findViewById(R.id.recipeText);
        recipeName = view.findViewById(R.id.recipe_names);
        Button showRecipeButton = view.findViewById(R.id.showRecipe);

        showRecipeButton.setOnClickListener(showRecipeListener);

        return view;
    }

    private void showRecipe(){
        long selectedRecipe = recipeName.getSelectedItemId();
        recipeList.add(new recipeModel("Tteokbokki", getResources().getStringArray(R.array.recipe_ingredients_Tteokbokki), getResources().getStringArray(R.array.recipe_steps_Tteokbokki)));
        recipeList.add(new recipeModel("Sesame Peanut Noodles", getResources().getStringArray(R.array.recipe_ingredients_Sesame_Peanut_Noodles), getResources().getStringArray(R.array.recipe_steps_Sesame_Peanut_Noodles)));

        recipeModel sRecipe = recipeList.get((int)selectedRecipe);

        StringBuilder sb = new StringBuilder();
        sb.append("Ingredients: \n");
        for (String ingredient : sRecipe.getIngredients()){
            sb.append(ingredient).append("\n");
        }
        sb.append("\nSteps: \n");
        for (String step : sRecipe.getInstructions()){
            sb.append(step).append("\n");
        }

        recipeText.setText(sb.toString());
    }

    private final View.OnClickListener showRecipeListener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            showRecipe();
        }
    };


}
