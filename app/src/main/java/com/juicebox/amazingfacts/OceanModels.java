package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class OceanModels {
    public OceanModels(String oceans) {
        this.oceans = oceans;
    }

    public OceanModels(){

    }

    public String oceans;

    public String getOceans() {
        return oceans;
    }

    public void setOceans(String oceans) {
        this.oceans = oceans;
    }
}
