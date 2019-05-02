package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class ComputerModels {
    public String getMycomputer() {
        return mycomputer;
    }

    public void setMycomputer(String mycomputer) {
        this.mycomputer = mycomputer;
    }

    public String mycomputer;

    public ComputerModels(){}
    public ComputerModels(String mycomputer){this.mycomputer = mycomputer;}

}
