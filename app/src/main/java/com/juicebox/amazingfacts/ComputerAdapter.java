package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ViewHolder> {

    private List<ComputerModels> list;
    private String post_data;
    private TextView Computer_post;
    private static final String TAG = "Favorite";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.computer, viewGroup, false);
        return new ViewHolder(view);
    }


    public ComputerAdapter(List<ComputerModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        post_data = list.get(i).getMycomputer();
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

            Computer_post = view.findViewById(R.id.computer_posts);
            Computer_post.setText(post);

        }

    }
}



