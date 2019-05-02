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

public class SleepActivity extends AppCompatActivity {

    private List<SleepModels> mList;
    private RecyclerView mRecyclerView;
    private SleepAdapter mAdapter;
    private FirebaseFirestore firestore;
    private boolean isOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleepactivity);

        isNetworkAvailable(SleepActivity.this);
        if(isOn == false){
            Toast.makeText(SleepActivity.this, "Turn on data", Toast.LENGTH_SHORT).show();
        }

        firestore = FirebaseFirestore.getInstance();
        mRecyclerView = findViewById(R.id.sleeprecycler);

        mList = new ArrayList<>();
        mAdapter = new SleepAdapter(mList);

        getSupportActionBar().setTitle("Sleep Facts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(SleepActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        firestore.collection("Sleep").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                for(DocumentChange doc:queryDocumentSnapshots.getDocumentChanges()){

                    if(doc.getType() == DocumentChange.Type.ADDED){

                        SleepModels model = doc.getDocument().toObject(SleepModels.class);
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
            Toast.makeText(SleepActivity.this, "Data is not on", Toast.LENGTH_SHORT).show();
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
