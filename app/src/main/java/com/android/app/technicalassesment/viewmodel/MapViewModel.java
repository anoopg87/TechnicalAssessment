package com.android.app.technicalassesment.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;
public class MapViewModel extends BaseObservable{
    public ObservableField<String> TITLE=new ObservableField<>(App.getApplicationInstance().getString(R.string.map_view));
    public MapViewModel() {
    }
}
