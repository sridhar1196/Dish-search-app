package com.example.sridh.inclass_08;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    //private OnFragmentInter mListener;
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,container, false);
        RecyclerView.LayoutManager mLayoutManager;
        RecyclerView.Adapter mAdapter;
        RecyclerView mRecyclerView;
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        mLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mAdapter = new FilteredListAdapter(SecondFragment.this, R.layout.final_item, recipes);
        mAdapter = new FilteredListAdapter(getActivity(), R.layout.final_item, recipes);
        mRecyclerView.setAdapter(mAdapter);
        view.findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInter) {
//            mListener = (OnFragmentInter) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInter");
//        }
    }
    public void getLisr(ArrayList<Recipe> recipes){
        this.recipes = recipes;
    }
//
}
