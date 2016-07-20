package com.android.app.technicalassesment.modules;

import com.android.app.technicalassesment.model.LocationInfo;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiInterface {
    /*

    Retrofit interface for calling the getLocationInfo webservice
     */


    @GET("/sample.json")
    Call<ArrayList<LocationInfo>> getLocationInfo();
}
