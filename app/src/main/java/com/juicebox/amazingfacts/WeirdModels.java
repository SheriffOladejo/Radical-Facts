package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class WeirdModels {

    public String getWeirds() {
        return weirds;
    }

    public void setWeirds(String weirds) {
        this.weirds = weirds;
    }

    public WeirdModels(String weirds) {
        this.weirds = weirds;
    }

    public WeirdModels(){

    }


    public String weirds;
}
