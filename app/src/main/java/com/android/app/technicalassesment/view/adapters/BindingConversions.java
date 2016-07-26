package com.android.app.technicalassesment.view.adapters;

import android.databinding.BindingConversion;
import android.view.View;


public class BindingConversions {

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visibility){
        return visibility? View.VISIBLE:View.GONE;
    }
}
