package com.juicebox.amazingfacts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<HistoryModels> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.historys, viewGroup, false);
        return new ViewHolder(view);
    }

    public HistoryAdapter(List<HistoryModels> list){
        this.list = list;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        String post_data = list.get(i).getHistory();
        viewHolder.setHistory(post_data);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView History_post;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            view = itemView;

        }

        public void setHistory(String post){

            History_post = view.findViewById(R.id.history_post);
            History_post.setText(post);

        }
    }
}
