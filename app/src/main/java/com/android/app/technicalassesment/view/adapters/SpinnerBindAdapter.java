package com.android.app.technicalassesment.view.adapters;

import android.databinding.BindingAdapter;
import android.widget.Spinner;

import com.android.app.technicalassesment.model.LocationInfo;

import java.util.List;

@SuppressWarnings("ALL")
public class SpinnerBindAdapter {

    /*
    Binding adapter for the spinner
     */

       @BindingAdapter("app:setSpinner")
        public static void setSpinnerAdapter(Spinner sp, List<LocationInfo> locationInfo){
        SpinnerAdapter spinnerAdapter=new SpinnerAdapter(locationInfo);
        sp.setAdapter(spinnerAdapter);
    }


}
