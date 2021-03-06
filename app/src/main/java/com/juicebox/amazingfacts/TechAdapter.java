package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.ViewHolder> {

    private List<TechModels> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tech, viewGroup, false);
        return new ViewHolder(view);
    }


    public TechAdapter(List<TechModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String post_data = list.get(i).getMytech();
        viewHolder.setCaption(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView Tech_post;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setCaption(String post){

            Tech_post = view.findViewById(R.id.tech_post);
            Tech_post.setText(post);

        }
    }

}
