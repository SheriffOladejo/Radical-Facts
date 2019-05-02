package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class SportModels {

    public String getSportss() {
        return sportss;
    }

    public SportModels(){

    }

    public void setSportss(String sportss) {
        this.sportss = sportss;
    }

    public SportModels(String sportss) {
        this.sportss = sportss;
    }

    public String sportss;
}
