package com.juicebox.amazingfacts;

import android.support.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@com.google.firebase.database.IgnoreExtraProperties
@Keep
public class HistoryModels {
    public String history;

    public HistoryModels(String history) {
        this.history = history;
    }

    public HistoryModels(){}


    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
