package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<CarModels> list;
    private String post_data;
    private TextView Car_post;
    private static final String TAG = "Favorite";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car, viewGroup, false);
        return new ViewHolder(view);
    }


    public CarAdapter(List<CarModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        post_data = list.get(i).getMycar();
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

            Car_post = view.findViewById(R.id.car_posts);
            Car_post.setText(post);

        }

    }
}



