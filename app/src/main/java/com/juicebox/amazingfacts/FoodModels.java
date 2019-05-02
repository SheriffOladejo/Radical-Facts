package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class FoodModels {

    public String food;

    public FoodModels(){}

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public FoodModels(String food) {
        this.food = food;
    }
}

