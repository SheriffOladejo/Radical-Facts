package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class EarthModels {

    public String myearth;

    public EarthModels(){}

    public String getMyearth() {
        return myearth;
    }

    public void setMyearth(String myearth) {
        this.myearth = myearth;
    }

    public EarthModels(String myearth) {
        this.myearth = myearth;
    }
}
