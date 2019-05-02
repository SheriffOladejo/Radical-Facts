package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class MathsModels {
    public String getMaths() {
        return maths;
    }

    public MathsModels(){

    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public MathsModels(String maths) {
        this.maths = maths;
    }

    public String maths;

}
