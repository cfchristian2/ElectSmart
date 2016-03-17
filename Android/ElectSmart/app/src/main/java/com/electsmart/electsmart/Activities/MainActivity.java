package com.electsmart.electsmart.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.electsmart.electsmart.Fragments.AddressDialogFragment;
import com.electsmart.electsmart.PreferencesManager;
import com.electsmart.electsmart.R;
import com.electsmart.electsmart.geolocation.FetchAddressIntentService;
import com.electsmart.electsmart.geolocation.GeolocationConstants;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private GoogleApiClient mGoogleApiClient;

    protected Location mLastLocation;
    private AddressResultReceiver mResultReceiver;
    protected String mAddressOutput;

    private PreferencesManager mPrefsManager;

    private TextView mAddressText;
    private Button mContinueButton;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpViewElements();

        PreferencesManager.initializeInstance(this);
        mPrefsManager = PreferencesManager.getInstance();

        if(!TextUtils.isEmpty(mPrefsManager.getAddress())) {
            Log.d(TAG, "Used saved address");
            moveToNextView();
        }

        mResultReceiver = new AddressResultReceiver(new Handler());

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    private void setUpViewElements() {
        mAddressText = (TextView) findViewById(R.id.addressInfo);

        mContinueButton = (Button) findViewById(R.id.continueButton);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrefsManager.setAddress(mAddressOutput);
                moveToNextView();
            }
        });

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        try {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);

            if (mLastLocation != null) {
                // Determine whether a Geocoder is available.
                if (!Geocoder.isPresent()) {
                    Toast.makeText(this, R.string.no_geocoder_available,
                            Toast.LENGTH_LONG).show();
                    return;
                }

                mPrefsManager.setLatLng(mLastLocation);
                //if (mAddressRequested) {
                startIntentService();
                // }
            }

        } catch(SecurityException e) {

        }
    }

    @Override
    public void onConnectionSuspended(int value) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    protected void startIntentService() {
        Intent intent = new Intent(this, FetchAddressIntentService.class);
        intent.putExtra(GeolocationConstants.RECEIVER, mResultReceiver);
        intent.putExtra(GeolocationConstants.LOCATION_DATA_EXTRA, mLastLocation);
        startService(intent);
    }

    private void moveToNextView() {
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);

        finish();
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void displayAddressOutput() {
        mAddressText.setText(mAddressOutput);
    }

    @SuppressLint("ParcelCreator")
    class AddressResultReceiver extends ResultReceiver {

        public AddressResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            // Display the address string
            // or an error message sent from the intent service.
            mAddressOutput = resultData.getString(GeolocationConstants.RESULT_DATA_KEY);
//            displayAddressOutput();

            mProgressBar.setVisibility(View.INVISIBLE);
            // Show a toast message if an address was found.
            if (resultCode == GeolocationConstants.SUCCESS_RESULT) {
                //showToast(getString(R.string.address_found));
                displayAddressOutput();
            } else if (resultCode == GeolocationConstants.FAILURE_RESULT) {
                //TODO handle the case with no address
                DialogFragment newFragment = new AddressDialogFragment();
                newFragment.show(getSupportFragmentManager(), "address");
            }

        }
    }


}
