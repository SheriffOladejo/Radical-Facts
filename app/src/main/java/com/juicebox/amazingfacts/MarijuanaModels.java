package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class MarijuanaModels {

    public String getWeed() {
        return weed;
    }

    public MarijuanaModels(){}

    public MarijuanaModels(String weed) {
        this.weed = weed;
    }

    public void setWeed(String weed) {
        this.weed = weed;
    }

    public String weed;
}
