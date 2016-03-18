package com.electsmart.electsmart.Activities;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.electsmart.electsmart.PreferencesManager;
import com.electsmart.electsmart.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PollingPlaceActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = PollingPlaceActivity.class.getSimpleName();

    private static final float ZOOM_AMOUNT = 13;

    private PreferencesManager mPrefsManager;
    private Location mUserLocation;
    private Location mPollingLocation;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling_place);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        PreferencesManager.initializeInstance(this);
        mPrefsManager = PreferencesManager.getInstance();

        mUserLocation = mPrefsManager.getLatLng();
        mPollingLocation = getPollingLocation();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker for the user's current location
        LatLng userLocation = new LatLng(mUserLocation.getLatitude(), mUserLocation.getLongitude());
        mMap.addMarker(new MarkerOptions().position(userLocation).title("Your Saved Address"));

        Location current = null;
        try {
            mMap.setMyLocationEnabled(true);

            Criteria criteria = new Criteria();
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            String provider = locationManager.getBestProvider(criteria, false);
            current = locationManager.getLastKnownLocation(provider);

        } catch(SecurityException e) {
            //if location isn't enabled
            Log.d(TAG, "Location isn't enabled");
        }

        //if couldn't find current location zoom in on saved address
        if(null == current) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLocation, ZOOM_AMOUNT));
        } else {
            //zoom in on current location
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(current.getLatitude(), current.getLongitude()), ZOOM_AMOUNT));
        }

        //Add a marker for their polling place
        LatLng pollingLocation = new LatLng(mPollingLocation.getLatitude(), mPollingLocation.getLongitude());
        mMap.addMarker(new MarkerOptions().position(pollingLocation).title("Your Polling Location"));
    }

    //TODO: Get real polling location
    private Location getPollingLocation() {
        Location ret = new Location("Test");
        ret.setLatitude(43.0717390);
        ret.setLongitude(-89.4102910);

        return ret;
    }
}
