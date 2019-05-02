package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class TechModels {

    public String mytech;

    public TechModels(){}

    public String getMytech() {
        return mytech;
    }

    public void setMytech(String mytech) {
        this.mytech = mytech;
    }

    public TechModels(String mytech) {
        this.mytech = mytech;
    }
}
