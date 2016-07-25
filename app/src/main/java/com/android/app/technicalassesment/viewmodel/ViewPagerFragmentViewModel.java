package com.android.app.technicalassesment.viewmodel;


import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;

import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;

@SuppressWarnings("unused")
public class ViewPagerFragmentViewModel extends BaseObservable {

    public ViewPagerFragmentViewModel() {
    }

    public void onFragmentClick(View v){
        Context context=App.getApplicationInstance();
        String msg=context.getResources().getString(R.string.fragment)+" "+v.getTag();
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
