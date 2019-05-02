package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class MovieModels {

    public String mymovie;

    public String getMymovie() {
        return mymovie;
    }

    public MovieModels(){}

    public void setMymovie(String mymovie) {
        this.mymovie = mymovie;
    }

    public MovieModels(String mymovie) {
        this.mymovie = mymovie;
    }
}
