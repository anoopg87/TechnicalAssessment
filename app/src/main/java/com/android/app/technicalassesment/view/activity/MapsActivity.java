package com.android.app.technicalassesment.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.databinding.MapActivityLayoutBinding;
import com.android.app.technicalassesment.model.LocationInfo;
import com.android.app.technicalassesment.viewmodel.MapViewModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// MapFragment to display the location
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private LocationInfo locationInfo;
    public static final String LOCATION_INFO="location_info";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapActivityLayoutBinding binding= DataBindingUtil.setContentView(MapsActivity.this,R.layout.map_activity_layout);
        binding.setHandler(new MapViewModel());
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        // get the selected location information from the main class
        locationInfo=getIntent().getParcelableExtra(LOCATION_INFO);


        // Can not able to bind SupportMapFragment object
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        if(null!=locationInfo){
            LatLng location = new LatLng(Double.valueOf(locationInfo.getLocation().getLatitude()), Double.valueOf(locationInfo.getLocation().getLongitude()));
            googleMap.addMarker(new MarkerOptions().position(location).title(locationInfo.getName()));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(locationInfo.getLocation().getLatitude()), Double.valueOf(locationInfo.getLocation().getLongitude())), 12.0f));
        }

    }
}
