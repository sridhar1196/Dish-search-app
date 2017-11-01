package com.example.sridh.inclass_08;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FirstFragment extends Fragment implements ResultsListAdapter.passData {

    private OnFragmentInteractionListener mListener;
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    String url="http://www.recipepuppy.com/api/";
    String dishname="";
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    RecyclerView mRecyclerView;
    OnFragmentInteractionListener fragmentInteractionListener;
    ArrayList<Recipe> finalRecipe=new ArrayList<Recipe>();
    public ArrayList<String> ingredients=new ArrayList<String>();
    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(ArrayList<Recipe> n) {
        this.recipes = n;
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_first,container, false);
        ingredients.add("");
        //RecyclerView.LayoutManager mLayoutManager;
        //RecyclerView.Adapter mAdapter;
        mRecyclerView = (RecyclerView) view.findViewById(R.id.resultsListView);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout managerq
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ResultsListAdapter(FirstFragment.this, R.layout.results, ingredients);
        mRecyclerView.setAdapter(mAdapter);
        List<ContentValues> list = new ArrayList<>();
        view.findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText dish_name = (EditText) getActivity().findViewById(R.id.dish_name);
                dishname = dish_name.getText().toString();
                if(dishname.trim().isEmpty()){
                    Toast.makeText(getActivity(),"Empty dish name",Toast.LENGTH_SHORT).show();
                } else {
//                    int size = mAdapter.getItemCount();
//                    for(int x =0 ;x<size;x++){
//                        int itemId = (int) mAdapter.getItemId(x);
//                        View view1 = mRecyclerView.findViewById(itemId);
//                    }
                    url="http://www.recipepuppy.com/api/";
                    Boolean first = false;
                    for(int i=0;i<ingredients.size();i++)
                    {
                        if(!(ingredients.get(i).trim().isEmpty())){
                            if (first){
                                url+=",";
                                url+=ingredients.get(i).trim();
                            } else {
                                url+="?i=";
                                first = true;
                                url+=ingredients.get(i).trim();
                            }
                        }

                    }
                    if(first){
                        url+="&q=";
                    } else {
                        url+="?&q=";
                    }
                    url+=dishname.trim();

                    Log.d("demo",url);
                    new GetData(new GetData.AsyncResponse(){

                        @Override
                        public void processFinish(ArrayList<Recipe> musicList) {
                            if(musicList == null){
                                Toast.makeText(getActivity(),"Empty search result",Toast.LENGTH_SHORT).show();
                            } else if(musicList.size() == 0){
                                Toast.makeText(getActivity(),"Empty search result",Toast.LENGTH_SHORT).show();
                            } else {
                                mListener.onFragmentInteraction(musicList);
                            }
                        }
                    }).execute(url);
                }

            }
        });
        return view;

    }

    public ArrayList<String> listview1(){
        int count = mRecyclerView.getChildCount();
        ingredients.clear();
        for(int x = 0;x<count;x++){
            View view1 = mRecyclerView.getChildAt(x);
            EditText e1 = (EditText) view1.findViewById(R.id.edit_value);
            ingredients.add(e1.getText().toString());
        }
        Log.d("demo","ingredients:"+ingredients.toString());
        return ingredients;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void sendData(ArrayList<String> str) {
        this.ingredients = str;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(ArrayList<Recipe> receipe);
    }

}
