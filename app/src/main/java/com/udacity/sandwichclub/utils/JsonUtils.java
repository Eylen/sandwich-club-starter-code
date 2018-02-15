package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject sandwichJson = new JSONObject(json);

            sandwich.setImage(sandwichJson.getString("image"));
            sandwich.setDescription(sandwichJson.getString("description"));
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));

            JSONObject names = sandwichJson.getJSONObject("name");
            JSONArray alsoKnownJson = names.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownJson.length(); i++){
                alsoKnownAs.add(alsoKnownJson.getString(i));
            }
            sandwich.setMainName(names.getString("mainName"));
            sandwich.setAlsoKnownAs(alsoKnownAs);

            JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJson.length(); i++){
                ingredients.add(ingredientsJson.getString(i));
            }
            sandwich.setIngredients(ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
