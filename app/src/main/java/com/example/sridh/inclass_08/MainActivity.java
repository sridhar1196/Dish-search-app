package com.example.sridh.inclass_08;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {
    ArrayList<Recipe> recipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(ArrayList<Recipe> receipe) {
        this.recipes = receipe;
    }
}
