package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class InternetModels {

    public String getMyinternet() {
        return myinternet;
    }

    public void setMyinternet(String myinternet) {
        this.myinternet = myinternet;
    }

    public String myinternet;
    public InternetModels(){}
    public InternetModels(String myinternet){
        this.myinternet = myinternet;
    }

}
