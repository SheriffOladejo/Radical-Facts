package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class CarModels {

    public String getMycar() {
        return mycar;
    }

    public void setMycar(String mycar) {
        this.mycar = mycar;
    }

    public String mycar;
    public CarModels(){}
    public CarModels(String mycar){this.mycar = mycar;}

}
