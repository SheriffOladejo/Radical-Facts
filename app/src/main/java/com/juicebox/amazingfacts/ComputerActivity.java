package com.juicebox.amazingfacts;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ComputerActivity extends AppCompatActivity {

    private List<ComputerModels> mList;
    private RecyclerView mRecyclerView;
    private ComputerAdapter mAdapter;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        mRecyclerView = findViewById(R.id.computer_recyclerview);

        mList = new ArrayList<>();
        mAdapter = new ComputerAdapter(mList);

        getSupportActionBar().setTitle("Computer Facts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(ComputerActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);


        firestore = FirebaseFirestore.getInstance();

        firestore.collection("Computers").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                for(DocumentChange doc:queryDocumentSnapshots.getDocumentChanges()){

                    if(doc.getType() == DocumentChange.Type.ADDED){

                        ComputerModels model = doc.getDocument().toObject(ComputerModels.class);
                        mList.add(model);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}
