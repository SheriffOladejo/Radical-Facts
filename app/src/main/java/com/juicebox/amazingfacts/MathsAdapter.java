package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MathsAdapter extends RecyclerView.Adapter<MathsAdapter.ViewHolder> {

    private List<MathsModels> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.maths, viewGroup, false);
        return new ViewHolder(view);
    }


    public MathsAdapter(List<MathsModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String post_data = list.get(i).getMaths();
        viewHolder.setCaption(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView Math_post;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setCaption(String post){

            Math_post = view.findViewById(R.id.maths_post);
            Math_post.setText(post);

        }
    }

}
