package com.juicebox.amazingfacts;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    String items[];
    int images[];


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.custom_row, viewGroup, false);
        Item item = new Item(row);
        return item;
    }


    public adapter(Context context, String items[], int images[]){
        this.context = context;
        this.items = items;
        this.images = images;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((Item)viewHolder).textView.setText(items[i]);
        ((Item)viewHolder).image.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    public class Item extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        ImageView image;
        CardView cardview;


        public Item(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            textView = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.image);
            cardview = itemView.findViewById(R.id.card);
        }

        @Override
        public void onClick(final View v) {

            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent = new Intent(v.getContext(), AnimalsActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), BrainActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), CarActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), ComputerActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), FoodActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), HistoryActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), InternetActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(v.getContext(), MarijuanaActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(v.getContext(), MathsActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(v.getContext(), MovieActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(v.getContext(), OceanActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 11:
                    intent = new Intent(v.getContext(), WeirdActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 12:
                    intent = new Intent(v.getContext(), SleepActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 13:
                    intent = new Intent(v.getContext(), SportActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 14:
                    intent = new Intent(v.getContext(), TechActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 15:
                    intent = new Intent(v.getContext(), EarthActivity.class);
                    v.getContext().startActivity(intent);
                    break;
            }
        }
    }

}









