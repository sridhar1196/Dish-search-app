package com.example.sridh.inclass_08;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilteredListAdapter extends RecyclerView.Adapter<FilteredListAdapter.ViewHolder>
{
    ArrayList<Recipe> list;
    SecondFragment mContext;
    Context passContext;
    static SecondFragment context;
    int oResourse;

//    public FilteredListAdapter(@NonNull SecondFragment context, int oResourse, @NonNull ArrayList<Recipe> objects) {
//        if(objects != null){
//            this.list = objects;
//            this.context = context;
//            this.oResourse = oResourse;
//        }
//    }
    public FilteredListAdapter(Context context, int oResourse, @NonNull ArrayList<Recipe> objects) {
        //if(objects != null){
            this.list = objects;
            this.passContext = context;
            this.oResourse = oResourse;
       // }
    }

    public FilteredListAdapter() {

    }


    @Override
    public FilteredListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.final_item, parent, false);
        FilteredListAdapter.ViewHolder viewHolder=new FilteredListAdapter.ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(FilteredListAdapter.ViewHolder holder, int position) {

        Recipe email = list.get(position);
        holder.dishName.setText(email.getTitle().toString());
        holder.dishIngredients.setText(email.getIngredients().toString());
        holder.dishURL.setText(email.getHref().toString());
        holder.list = list;
        holder.context = passContext;
        //holder.dishImage;
        //Log.d("demo thumbnail",context.toString()+" = "+mContext.toString());
        if (!email.getThumbnail().equals("")) {
            Picasso.with(passContext).load(email.getThumbnail()).fit().into(holder.dishImage);
        }
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView dishName,dishIngredients,dishURL;
        public ImageView dishImage;
        Context context;
        ArrayList<Recipe> list;
        int position;
        public ViewHolder(View itemView)
        {
            super(itemView);
            dishName =(TextView) itemView.findViewById(R.id.dishName);
            dishIngredients =(TextView) itemView.findViewById(R.id.dishIngredients);
            dishURL =(TextView) itemView.findViewById(R.id.dishURL);
            dishImage = (ImageView) itemView.findViewById(R.id.dishImage);
            dishURL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(list.get(position).getHref()));
                    context.startActivity(i);
                }
            });
        }
    }

}
