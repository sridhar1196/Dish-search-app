package com.example.sridh.inclass_08;

import java.util.ArrayList;

/**
 * Created by sridh on 9/25/2017.
 */

public class Recipe {

    String title,thumbnail,ingredients,href;

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ArrayList<String> imageUrls=new ArrayList<String>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
