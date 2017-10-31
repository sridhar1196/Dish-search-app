package com.example.sridh.inclass_08;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ResultsListAdapter extends RecyclerView.Adapter<ResultsListAdapter.ViewHolder> {
    ArrayList<String> list;
    FirstFragment mContext;
    FirstFragment context;
    int oResourse;
    passData pass;

    public ResultsListAdapter(@NonNull FirstFragment context, int oResourse, @NonNull ArrayList<String> objects) {
        this.list = objects;
        Log.d("result_list",list.toString());
        this.context = context;
        this.oResourse = oResourse;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.results, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;

    }
    public interface passData{
        void sendData(ArrayList<String> str);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.context = context;
        holder.list = list;
        holder.receipe.setText(list.get(position));
        holder.image.setImageResource(R.drawable.remove);
        if(position == (list.size() - 1)){
            holder.image.setImageResource(R.drawable.add);
        }
//        for(int x =0;x<list.size();x++){
//            if(x == (list.size() - 1)){
//                holder.image.setImageResource(R.drawable.add);
//            } else {
//                holder.image.setImageResource(R.drawable.remove);
//            }
//        }
        holder.position = position;
        holder.pass = pass;
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public EditText receipe;
        public ImageView image;
        Recipe email;
        FirstFragment context;
        ArrayList<String> list;
        int position;
        passData pass;
        public ViewHolder(View itemView)
        {
            super(itemView);
            receipe=(EditText) itemView.findViewById(R.id.edit_value);
            image = (ImageView) itemView.findViewById(R.id.image);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if((list.size() - 1) == position){
                        if(list.size() == 5){
                            list.set(position,receipe.getText().toString());
                            Toast.makeText(context.getContext(),"Maximum 5 ingredients can be added",Toast.LENGTH_SHORT).show();
                        } else {
                            list.set(position,receipe.getText().toString());
                            list.add(" ");
                            if(list != null){
                                context.setIngredients(list);
                            }
                            ResultsListAdapter.this.notifyDataSetChanged();
                        }

                    } else {
                        list.remove(position);
                        if(list != null){
                            context.setIngredients(list);
                        }
                        ResultsListAdapter.this.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
