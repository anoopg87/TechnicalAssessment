package com.android.app.technicalassesment.modules;
import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.model.LocationInfo;
import com.android.app.technicalassesment.modules.ApiInterface;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class ApiImplementation {

    /*
    ApiImplementation class used for implementing the Retrofit webservice call

    Only one method is available as of now

    getLocationInfo used for getting the location info from the webservice

    @params IWebServiceResponse callback send the response to the implemented class


     */


    public static void getLocationInfo(IWebServiceResponse<LocationInfo> callBack){
        ApiInterface apiInterface= App.getRetrofitInstance().create(ApiInterface.class);
        Call<ArrayList<LocationInfo>> locationInfo= apiInterface.getLocationInfo();
        locationInfo.clone().enqueue(new Callback<ArrayList<LocationInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<LocationInfo>> call, Response<ArrayList<LocationInfo>> response) {

                callBack.onSuccess(response.body());
            }
            @Override
            public void onFailure(Call<ArrayList<LocationInfo>> call, Throwable t) {

                callBack.onError(App.getApplicationInstance().getResources().getString(R.string.network_error));
            }
        });
    }
}
