package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class BrainModels {

    public String mybrain;

    public BrainModels(){}

    public String getMybrain() {
        
        return mybrain;
    }

    public void setMybrain(String mybrain) {
        this.mybrain = mybrain;
    }

    public BrainModels(String mybrain){
        this.mybrain = mybrain;
    }

}
