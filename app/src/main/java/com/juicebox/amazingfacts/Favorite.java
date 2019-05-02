package com.juicebox.amazingfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Favorite extends AppCompatActivity {

    private TextView Favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Bundle getFavotite = getIntent().getExtras();
        String favorite = getFavotite.getString("Favorite");
        Favorite = findViewById(R.id.favorite);
        Favorite.setText(favorite);
    }
}
