package com.electsmart.electsmart.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.electsmart.electsmart.PreferencesManager;
import com.electsmart.electsmart.R;

public class SettingsActivity extends AppCompatActivity {

    private EditText mAddressEditText;
    private ToggleButton mNationalElectionToggle, mStateElectionToggle, mLocalElectionToggle, mNotificationsToggle;

    private PreferencesManager mPrefsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        PreferencesManager.initializeInstance(this);
        mPrefsManager = PreferencesManager.getInstance();

        initializeUIFields();
    }

    public void initializeUIFields() {
        mAddressEditText = (EditText) findViewById(R.id.addressEditText);
        mAddressEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //update the preference whenever text is changed
                mPrefsManager.setAddress(s.toString());
            }
        });

        mNationalElectionToggle = (ToggleButton) findViewById(R.id.nationalElectionToggle);
        mNationalElectionToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPrefsManager.setNationalToggle(isChecked);
            }
        });

        mStateElectionToggle = (ToggleButton) findViewById(R.id.stateElectionToggle);
        mStateElectionToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPrefsManager.setStateToggle(isChecked);
            }
        });

        mLocalElectionToggle = (ToggleButton) findViewById(R.id.localElectionToggle);
        mLocalElectionToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPrefsManager.setLocalToggle(isChecked);
            }
        });

        mNotificationsToggle = (ToggleButton) findViewById(R.id.notificationsToggle);
        mNotificationsToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPrefsManager.setNotificationsToggle(isChecked);
            }
        });

        mAddressEditText.setText(mPrefsManager.getAddress());
        mNationalElectionToggle.setChecked(mPrefsManager.getNationalToggle());
        mStateElectionToggle.setChecked(mPrefsManager.getStateToggle());
        mLocalElectionToggle.setChecked(mPrefsManager.getLocalToggle());
        mNotificationsToggle.setChecked(mPrefsManager.getNotificationsToggle());
    }
}
