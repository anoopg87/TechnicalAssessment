package com.android.app.technicalassesment.view.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.android.app.technicalassesment.R;
import com.android.app.technicalassesment.model.LocationInfo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// Mapfragment to display the location
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    LocationInfo locationInfo;
    Toolbar toolbar;
    public static final String LOCATION_INFO="location_info";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity_layout);
        toolbar=((Toolbar)findViewById(R.id.toolbar));

        toolbar.setTitle(getResources().getString(R.string.map_view));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(toolbar);
        // get the selected location information from the main class
        locationInfo=getIntent().getParcelableExtra(LOCATION_INFO);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        if(null!=locationInfo){
            LatLng location = new LatLng(Double.valueOf(locationInfo.getLocation().getLatitude()), Double.valueOf(locationInfo.getLocation().getLongitude()));
            mMap.addMarker(new MarkerOptions().position(location).title(locationInfo.getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Double.valueOf(locationInfo.getLocation().getLatitude()), Double.valueOf(locationInfo.getLocation().getLongitude())), 12.0f));
        }

    }
}
