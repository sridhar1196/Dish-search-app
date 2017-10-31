package com.example.sridh.inclass_08;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;


public class GetData extends AsyncTask<String,Void,ArrayList<Recipe>> {
    public AsyncResponse response;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public GetData(AsyncResponse asyncResponse) {
        this.response = asyncResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //context.setContentView(R.layout.loading);
    }

    @Override
    protected void onPostExecute(ArrayList<Recipe> favorites) {
        super.onPostExecute(favorites);
        Log.d("demo",favorites.toString());
        response.processFinish(favorites);
    }

    @Override
    protected ArrayList<Recipe> doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            Log.d("URL","Value"+strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int status = con.getResponseCode();
            if(status == HttpURLConnection.HTTP_OK){
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = reader.readLine();

                while (line != null){
                    sb.append(line);
                    line = reader.readLine();
                }
                return RecipeUtil.RecipeJSONParser.parseRecipes(sb.toString());
            }
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public interface AsyncResponse {
        void processFinish(ArrayList<Recipe> musicList);
    }
}