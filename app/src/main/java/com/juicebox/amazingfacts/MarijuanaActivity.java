package com.juicebox.amazingfacts;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MarijuanaActivity extends AppCompatActivity {

    private List<MarijuanaModels> mList;
    private MarijuanaAdapter mAdapter;
    private FirebaseFirestore firestore;
    private RecyclerView mRecyclerView;
    private boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marijuanaactivity);

        isNetworkAvailable(MarijuanaActivity.this);
        if(isOn == false) {
            Toast.makeText(MarijuanaActivity.this, "Turn on data", Toast.LENGTH_SHORT).show();
        }

        mList = new ArrayList<>();

        getSupportActionBar().setTitle("Marijuana Facts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = findViewById(R.id.marijuana_recyclerview);

        mAdapter = new MarijuanaAdapter(mList);
        firestore = FirebaseFirestore.getInstance();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        firestore.collection("Marijuana").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                for(DocumentChange doc:queryDocumentSnapshots.getDocumentChanges()){

                    if(doc.getType() == DocumentChange.Type.ADDED){

                        MarijuanaModels model = doc.getDocument().toObject(MarijuanaModels.class);
                        mList.add(model);
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    public boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity == null){
            Log.d("NetworkCheck", "isNetworkAvailable: No");
            Toast.makeText(MarijuanaActivity.this, "Data is not on", Toast.LENGTH_SHORT).show();
            return false;
        }

        // get network info for all of the data interfaces (e.g Wifi, 3G, LTE, etc
        NetworkInfo[] info = connectivity.getAllNetworkInfo();

        // make sure that there is at least one interface to test against
        if(info != null){
            // iterate through the intrefaces
            for(int i = 0; i < info.length; i++){
                // check this interface for a connected state
                if(info[i].getState() == NetworkInfo.State.CONNECTED){
                    Log.d("NetworkCheck", "isNetworkAvailable: Yes");
                    //Toast.makeText(MainActivity.this, "Data is on", Toast.LENGTH_SHORT).show();
                    isOn = true;
                    return true;
                }
            }
        }
        return false;
    }
}
