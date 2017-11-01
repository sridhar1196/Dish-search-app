package com.example.sridh.inclass_08;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
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
    String editedtext;

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
                    Log.d("demo",list.toString());
                    Log.d("demo","position:"+position);
                    if((list.size() - 1) == position){
                        if(list.size() == 5){
                            Toast.makeText(context.getContext(),"Maximum 5 ingredients can be added",Toast.LENGTH_SHORT).show();
                        } else {
                            list.set(position,receipe.getText().toString());
                            list.add("");
                            ResultsListAdapter.this.notifyDataSetChanged();
                        }

                    } else {
                        ArrayList<String> temp = new ArrayList<String>();
                        temp.addAll(context.listview1());
                        for(int x =0;x<temp.size();x++){
                            list.set(x,temp.get(x));
                        }
                        list.remove(position);
                        ResultsListAdapter.this.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
