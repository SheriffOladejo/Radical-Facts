package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WeirdAdapter extends RecyclerView.Adapter<WeirdAdapter.ViewHolder> {

    private List<WeirdModels> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weird, viewGroup, false);
        return new ViewHolder(view);
    }


    public WeirdAdapter(List<WeirdModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String post_data = list.get(i).getWeirds();
        viewHolder.setMovie(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView weird_post;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setMovie(String post){

            weird_post = view.findViewById(R.id.weird_post);
            weird_post.setText(post);

        }
    }

}

