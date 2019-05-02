package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MarijuanaAdapter extends RecyclerView.Adapter<MarijuanaAdapter.ViewHolder>{

    private List<MarijuanaModels> list;

    @NonNull
    @Override
    public MarijuanaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.marijuana, viewGroup, false);
        return new MarijuanaAdapter.ViewHolder(view);
    }


    public MarijuanaAdapter(List<MarijuanaModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull MarijuanaAdapter.ViewHolder viewHolder, int i) {

        String post_data = list.get(i).getWeed();
        viewHolder.setCaption(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView Marijuana_post;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setCaption(String post){

            Marijuana_post = view.findViewById(R.id.marijuana_post);
            Marijuana_post.setText(post);

        }
    }

}
