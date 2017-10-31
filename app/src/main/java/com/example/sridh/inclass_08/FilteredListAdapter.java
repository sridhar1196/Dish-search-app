package com.example.sridh.inclass_08;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FilteredListAdapter extends RecyclerView.Adapter<FilteredListAdapter.ViewHolder>
{
    ArrayList<Recipe> list;
    MainActivity mContext;
    Activity context;
    int oResourse;

    public FilteredListAdapter(@NonNull Activity context, int oResourse, @NonNull ArrayList<Recipe> objects) {
        if(objects != null){
            this.list = objects;
            this.context = context;
            if(context instanceof MainActivity){
                this.mContext = (MainActivity) context;
            }
            this.oResourse = oResourse;
        }
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

//        holder.app_name.setText(email.getName());
//        holder.price_value.setText(String.valueOf(email.getPrice()));
//        //holder.textViewSubject.setText(email.subject);
//
//        if(email.getPrice() < 1.99)
//        {
//            holder.star.setImageResource(R.drawable.price_low);
//        }
//        else if(email.getPrice() > 1.99 && email.getPrice() < 5.99) {
//            holder.star.setImageResource(R.drawable.price_medium);
//        }
//        else {
//            holder.star.setImageResource(R.drawable.price_high);
//        }
//        Picasso.with(context).load(email.getLargeImageURL()).into(holder.image);
//
//        holder.email=email;
//        holder.dm = dm;
//        holder.context = context;
//        holder.list = list;
//        holder.position = position;
//        holder.mContext = mContext;
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
        public TextView dishName,dishIn;
        public ImageView star;
        public ImageView image;
        public ImageView delete_icon;
        Activity context;
        ArrayList<Recipe> list;
        int position;
        MainActivity mContext;
        public ViewHolder(View itemView)
        {
            super(itemView);
//            app_name=(TextView)itemView.findViewById(R.id.dishName);
//            price_value=(TextView)itemView.findViewById(R.id.priceTextView);
//            star=(ImageView) itemView.findViewById(R.id.star);
//            image = (ImageView) itemView.findViewById(R.id.default_image);
//            delete_icon = (ImageView) itemView.findViewById(R.id.delete_icon);
//            delete_icon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("demo","delete clicked");
//                    Log.d("demo",list.get(position).toString());
//                    FilteredListAdapter.this.notifyDataSetChanged();
//                }
//            });

        }
    }

}
