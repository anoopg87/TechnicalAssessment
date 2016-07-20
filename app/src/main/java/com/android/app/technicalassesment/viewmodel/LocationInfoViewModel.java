package com.android.app.technicalassesment.viewmodel;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.android.app.technicalassesment.App;
import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.model.LocationInfo;
import com.android.app.technicalassesment.modules.ApiImplementation;
import com.android.app.technicalassesment.modules.IWebServiceResponse;
import com.android.app.technicalassesment.util.ConnectivityManger;
import com.android.app.technicalassesment.view.activity.MapsActivity;

@SuppressWarnings("ALL")
public class LocationInfoViewModel {


    /*
    LocationInfoViewModel includes the functionality for calling the webservice and also for navigating to the map screen

     */

    private final IWebServiceResponse iWebServiceResponse;

    public LocationInfoViewModel(IWebServiceResponse iWebServiceResponse) {
        this.iWebServiceResponse = iWebServiceResponse;
        initWebservice();
    }

    private void initWebservice(){

        if(ConnectivityManger.isConnecting(App.getApplicationInstance())) {
            ApiImplementation.getLocationInfo(iWebServiceResponse);
        }else{
            Toast.makeText(App.getApplicationInstance(),App.getApplicationInstance().getResources().getString(R.string.please_check_internet_connection),Toast.LENGTH_SHORT).show();
        }
    }
    public void navigateToMap(View v){
        LocationInfo locationInfo= (LocationInfo) v.getTag();
        App.getApplicationInstance().startActivity(new Intent(App.getApplicationInstance(),MapsActivity.class).putExtra(MapsActivity.LOCATION_INFO,locationInfo).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
