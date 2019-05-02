package com.juicebox.amazingfacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AnimalsActivity extends AppCompatActivity {

    private List<Models> mList;
    private RecyclerView mRecyclerView;
    private myAdapter mAdapter;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animalsactivity);

        firestore = FirebaseFirestore.getInstance();

        firestore.collection("Animals").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                for(DocumentChange doc:queryDocumentSnapshots.getDocumentChanges()){

                    if(doc.getType() == DocumentChange.Type.ADDED){

                        Models model = doc.getDocument().toObject(Models.class);
                        mList.add(model);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        mRecyclerView = findViewById(R.id.animalrecycler);

        mList = new ArrayList<>();
        mAdapter = new myAdapter(mList);

        getSupportActionBar().setTitle("Animal Facts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(AnimalsActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

    }

}
