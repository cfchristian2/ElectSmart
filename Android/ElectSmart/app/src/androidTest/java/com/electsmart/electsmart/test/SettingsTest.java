package com.electsmart.electsmart.test;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import com.electsmart.electsmart.*;
import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Activities.MainActivity;
import com.electsmart.electsmart.Activities.SettingsActivity;
import com.electsmart.electsmart.Activities.TabActivity;
import com.electsmart.electsmart.Models.Election;
import com.electsmart.electsmart.Models.UpcomingElectionRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class SettingsTest {

    private UiDevice mDevice;

    @Rule
    public IntentsTestRule<SettingsActivity> mActivityRule = new IntentsTestRule<SettingsActivity>(
            SettingsActivity.class){
        @Override
        protected void beforeActivityLaunched() {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
            super.beforeActivityLaunched();
        }
    };

    @Test
    public void ToggleNationalElectionsTest() {
        //Open More options menu

        UiObject showNationalElections = mDevice.findObject(new UiSelector().className("android.widget.ToggleButton").resourceId("com.electsmart.electsmart:id/nationalElectionToggle"));
        try {
            if (showNationalElections .exists() && showNationalElections .isEnabled()) {
                showNationalElections .click();
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException e) {
                //do nothing
            }
            if (showNationalElections .exists() && showNationalElections .isEnabled()) {
                showNationalElections .click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }
    }

    @Test
    public void ToggleStateElectionsTest() {
        //Open More options menu

        UiObject showStateElections = mDevice.findObject(new UiSelector().className("android.widget.ToggleButton").resourceId("com.electsmart.electsmart:id/stateElectionToggle"));
        try {
            if (showStateElections .exists() && showStateElections .isEnabled()) {
                showStateElections .click();
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException e) {
                //do nothing
            }
            if (showStateElections .exists() && showStateElections .isEnabled()) {
                showStateElections .click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }
    }

    @Test
    public void ToggleLocalElectionsTest() {
        //Open More options menu

        UiObject showLocalElections = mDevice.findObject(new UiSelector().className("android.widget.ToggleButton").resourceId("com.electsmart.electsmart:id/localElectionToggle"));
        try {
            if (showLocalElections .exists() && showLocalElections .isEnabled()) {
                showLocalElections .click();
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException e) {
                //do nothing
            }
            if (showLocalElections .exists() && showLocalElections .isEnabled()) {
                showLocalElections .click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }
    }

    @Test
    public void ToggleNotificationsElectionsTest() {
        //Open More options menu

        UiObject notificationToggle = mDevice.findObject(new UiSelector().className("android.widget.ToggleButton").resourceId("com.electsmart.electsmart:id/notificationsToggle"));
        try {
            if (notificationToggle .exists() && notificationToggle .isEnabled()) {
                notificationToggle .click();
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException e) {
                //do nothing
            }
            if (notificationToggle .exists() && notificationToggle .isEnabled()) {
                notificationToggle .click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }
    }

    @Test
    public void changeAddressTest() {
        //Open More options menu

        UiObject notificationToggle = mDevice.findObject(new UiSelector().className("android.widget.EditText").resourceId("com.electsmart.electsmart:id/addressEditText"));


        try {

            //clear Text Field
            if (notificationToggle .exists() && notificationToggle .isEnabled()) {
                notificationToggle.clearTextField();
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException e) {
                //do nothing
            }
            if (notificationToggle .exists() && notificationToggle .isEnabled()) {
                notificationToggle.setText("1234 Random Address Ave");
            }
            try{
                Thread.sleep(250);
            }catch(InterruptedException e) {
                //do nothing
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }
    }
}