package com.example.practice;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.Myholder> {
    public SecondAdapter(String[] data) {
        this.data = data;
    }

    String data[];

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.singlerow,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
       holder.txt.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class Myholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView txt;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.img1);
            txt =(TextView)itemView.findViewById(R.id.t1);
        }
    }

}
