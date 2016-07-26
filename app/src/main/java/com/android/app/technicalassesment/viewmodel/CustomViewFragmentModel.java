package com.android.app.technicalassesment.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

@SuppressWarnings("unused")
public class CustomViewFragmentModel {

    public  ObservableField<Integer> progress=new ObservableField<>(25);

    public CustomViewFragmentModel() {
    }

    public void progressButtonClick(Integer prgs){
            progress.set(prgs);
    }
}
