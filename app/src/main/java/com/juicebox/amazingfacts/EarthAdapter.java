package com.juicebox.amazingfacts;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EarthAdapter extends RecyclerView.Adapter<EarthAdapter.ViewHolder> {

    private List<EarthModels> list;
    private String post_data;
    private TextView Earth_post;
    private static final String TAG = "Favorite";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.earth, viewGroup, false);
        return new ViewHolder(view);
    }


    public EarthAdapter(List<EarthModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        post_data = list.get(i).getMyearth();
        viewHolder.setCaption(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setCaption(String post){

            Earth_post = view.findViewById(R.id.earth_posts);
            Earth_post.setText(post);

        }

    }
}

