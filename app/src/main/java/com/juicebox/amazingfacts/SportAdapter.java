package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder>{

    private List<SportModels> list;

    @NonNull
    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sport, viewGroup, false);
        return new SportAdapter.ViewHolder(view);
    }


    public SportAdapter(List<SportModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.ViewHolder viewHolder, int i) {

        String post_data = list.get(i).getSportss();
        viewHolder.setCaption(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView Sport_post;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setCaption(String post){

            Sport_post = view.findViewById(R.id.sport_post);
            Sport_post.setText(post);

        }
    }

}
