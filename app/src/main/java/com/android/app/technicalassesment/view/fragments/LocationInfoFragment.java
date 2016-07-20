package com.android.app.technicalassesment.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.LocationInformationFragmentBinding;
import com.android.app.technicalassesment.model.FromCentral;
import com.android.app.technicalassesment.model.LocationInfo;
import com.android.app.technicalassesment.modules.IWebServiceResponse;
import com.android.app.technicalassesment.viewmodel.LocationInfoViewModel;
import java.util.ArrayList;
import java.util.List;


public class LocationInfoFragment extends Fragment implements IWebServiceResponse<LocationInfo> {

    /*
    It used for showing the location information

    We call the API with the help of the LocationInfoViewModel class and the get the response to bind it with the spinner in the layout

    using the BindingAdapter fo the spinner the data will be loaded to the spinner

    On selecting the location from th spinner it will show the available mode of transport to the location.

    User can view the location using the Map by pressing the navigate button



     */



    private static final String TAG = "LocationFragment";
    LocationInformationFragmentBinding binding;
    List<LocationInfo> locationInfo=new ArrayList<>();

    public static LocationInfoFragment newInstance() {
        Bundle args = new Bundle();
         LocationInfoFragment fragment = new LocationInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle(getResources().getString(R.string.web_service_assessment_test));
        binding= DataBindingUtil.inflate(inflater,R.layout.location_information_fragment,container,false);
        binding.setLocationList(locationInfo);
        LocationInfoViewModel locationInfoViewModel=new LocationInfoViewModel(this);
        binding.setHandler(locationInfoViewModel);
        setSpinnerEvents();
        return binding.getRoot();
    }

    private void setSpinnerEvents(){
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                LocationInfo locationInfo=binding.getLocationList().get(i);
                binding.setLocationInfo(locationInfo);
                if(null!=locationInfo.getFromCentral()){
                    FromCentral fromcentral=locationInfo.getFromCentral();
                    String str=null!=fromcentral.getCar()?"Car :"+fromcentral.getCar()+"\n\n":"";
                    str+=null!=fromcentral.getTrain()?"Train :"+fromcentral.getTrain():"";
                    Log.d(TAG,str);
                    binding.setDirection(str);

                }else {
                    String str="";
                    binding.setDirection(str);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onSuccess(List<LocationInfo> result) {
        locationInfo=result;
        binding.setLocationList(locationInfo);
    }

    @Override
    public void onError(String error) {

    }


}
