package com.example.sridh.inclass_08;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {
    ArrayList<Recipe> recipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .add(R.id.content, new FirstFragment(),"first")
                .commit();
    }

    @Override
    public void onFragmentInteraction(ArrayList<Recipe> receipe) {
        this.recipes = receipe;
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.getLisr(receipe);
        getFragmentManager().beginTransaction()
                .replace(R.id.content,secondFragment,"second")
                .commit();
    }
}
