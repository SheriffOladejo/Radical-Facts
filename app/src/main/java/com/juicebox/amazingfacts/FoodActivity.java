package com.juicebox.amazingfacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private List<FoodModels> mList;
    private RecyclerView mRecyclerView;
    private FoodAdapter mAdapter;
    private FirebaseFirestore firestore;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodactivity);

        mList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.food_recyclerview);
        firestore = FirebaseFirestore.getInstance();
        mAdapter = new FoodAdapter(mList);


        getSupportActionBar().setTitle("Food Facts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(FoodActivity.this));
        mRecyclerView.setAdapter(mAdapter);

        progress = findViewById(R.id.foodProgress);

        progress.setVisibility(View.VISIBLE);
        firestore.collection("Food").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                for(DocumentChange doc:queryDocumentSnapshots.getDocumentChanges()){

                    if(doc.getType() == DocumentChange.Type.ADDED){

                        FoodModels model = doc.getDocument().toObject(FoodModels.class);
                        mList.add(model);
                        mAdapter.notifyDataSetChanged();

                    }

                }

            }
        });
        progress.setVisibility(View.INVISIBLE);
    }
}
