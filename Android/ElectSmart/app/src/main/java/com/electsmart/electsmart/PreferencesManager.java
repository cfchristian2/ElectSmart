package com.electsmart.electsmart;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;

public class PreferencesManager {

    private static final String TAG = PreferencesManager.class.getSimpleName();

    private static final String PREF_NAME = "com.electsmart.electsmart.preferences";
    private static final String ADDRESS_KEY = "com.electsmart.electsmart.ADDRESS_KEY";
    private static final String LATLNG_KEY = "com.electsmart.electsmart.LATLNG_KEY";
    private static final String NATIONAL_TOGGLE = "com.electsmart.electsmart.NATIONAL_TOGGLE";
    private static final String STATE_TOGGLE = "com.electsmart.electsmart.STATE_TOGGLE";
    private static final String LOCAL_TOGGLE = "com.electsmart.electsmart.LOCAL_TOGGLE";
    private static final String NOTIFICATIONS_TOGGLE = "com.electsmart.electsmart.NOTIFICATIONS_TOGGLE";

    private static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    public static synchronized PreferencesManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferencesManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setAddress(String address) {
        Log.d(TAG, "Address set to " + address);
        mPref.edit()
                .putString(ADDRESS_KEY, address)
                .apply();
    }

    public String getAddress() {
        return mPref.getString(ADDRESS_KEY, "");
    }

    public void removeAddress() {
        remove(ADDRESS_KEY);
    }

    public void setNationalToggle(boolean toggle) {
        Log.d(TAG, "National toggle set to " + toggle);
        mPref.edit()
                .putBoolean(NATIONAL_TOGGLE, toggle)
                .apply();
    }

    public boolean getNationalToggle() {
        return mPref.getBoolean(NATIONAL_TOGGLE, true);
    }

    public void setStateToggle(boolean toggle) {
        Log.d(TAG, "State toggle set to " + toggle);
        mPref.edit()
                .putBoolean(STATE_TOGGLE, toggle)
                .apply();
    }

    public boolean getStateToggle() {
        return mPref.getBoolean(STATE_TOGGLE, true);
    }

    public void setLocalToggle(boolean toggle) {
        Log.d(TAG, "Local toggle set to " + toggle);
        mPref.edit()
                .putBoolean(LOCAL_TOGGLE, toggle)
                .apply();
    }

    public boolean getLocalToggle() {
        return mPref.getBoolean(LOCAL_TOGGLE, true);
    }

    public void setNotificationsToggle(boolean toggle) {
        Log.d(TAG, "Notifications toggle set to " + toggle);
        mPref.edit()
                .putBoolean(NOTIFICATIONS_TOGGLE, toggle)
                .apply();
    }

    public boolean getNotificationsToggle() {
        return mPref.getBoolean(NOTIFICATIONS_TOGGLE, true);
    }

    public void setLatLng(Location latlng) {
        String vals = String.valueOf(latlng.getLatitude()) + "," + String.valueOf(latlng.getLongitude());

        Log.d(TAG, "LatLng set to " + vals);

        mPref.edit()
                .putString(LATLNG_KEY, vals)
                .apply();
    }

    public Location getLatLng() {
        String[] vals = mPref.getString(LATLNG_KEY, " , ").split(",");

        Location ret = new Location("Preferences");
        double lat = 0;
        double lng = 0;

        try {
            lat = Double.valueOf(vals[0]);
        } catch (NumberFormatException e) {

        }
        try {
            lng = Double.valueOf(vals[1]);
        } catch (NumberFormatException e) {

        }
        ret.setLatitude(lat);
        ret.setLongitude(lng);

        return ret;
    }

    private void remove(String key) {
        mPref.edit()
                .remove(key)
                .apply();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}
