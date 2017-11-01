package com.example.sridh.inclass_08;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by sridh on 9/25/2017.
 */

public class RecipeUtil {

    static public class RecipeJSONParser{
        static ArrayList<Recipe> parseRecipes(String in) throws JSONException {
            ArrayList<Recipe> recipesList = new ArrayList<Recipe>();
            JSONObject root = new JSONObject(in);
            //Log.d("demoutil",root.toString());
            JSONArray recipesJSONArray = root.getJSONArray("results");
            for (int i = 0; i < recipesJSONArray.length(); i++){
                JSONObject recipesJSONObject=recipesJSONArray.getJSONObject(i);
                Recipe recipe=new Recipe();
                recipe.setTitle(recipesJSONObject.getString("title").trim());
                //Log.d("demo",recipe.getTitle());
                recipe.setHref(recipesJSONObject.getString("href").trim());
                recipe.setIngredients(recipesJSONObject.getString("ingredients").trim());
                recipe.setThumbnail(recipesJSONObject.getString("thumbnail").trim());
                recipe.imageUrls.add(recipe.getThumbnail().trim());
                recipesList.add(recipe);
            }
            return recipesList;
        }
    }

}
