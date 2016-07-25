package com.android.app.technicalassesment.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

@SuppressWarnings("unused")
public class CustomViewFragmentModel {

    public  ObservableField<Integer> progress=new ObservableField<>(25);

    public CustomViewFragmentModel() {
    }

    public void progressButtonClick(View v){
        String value= (String) v.getTag();
        progress.set(Integer.valueOf(value));

    }
}
