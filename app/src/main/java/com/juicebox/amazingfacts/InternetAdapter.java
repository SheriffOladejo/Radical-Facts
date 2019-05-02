package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class InternetAdapter extends RecyclerView.Adapter<InternetAdapter.ViewHolder> {

    private List<InternetModels> list;
    private String post_data;
    private TextView Internet_post;
    private static final String TAG = "Favorite";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.internet, viewGroup, false);
        return new ViewHolder(view);
    }


    public InternetAdapter(List<InternetModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        post_data = list.get(i).getMyinternet();
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

            Internet_post = view.findViewById(R.id.internet_posts);
            Internet_post.setText(post);

        }

    }
}


