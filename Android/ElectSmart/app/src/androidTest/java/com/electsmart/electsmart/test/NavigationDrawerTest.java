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
public class NavigationDrawerTest {

    private UiDevice mDevice;

    @Rule
    public IntentsTestRule<TabActivity> mActivityRule = new IntentsTestRule<TabActivity>(
            TabActivity.class){
        @Override
        protected void beforeActivityLaunched() {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
            super.beforeActivityLaunched();
        }
    };

    @Test
    public void OpenNavigationDrawerTest() {
        //Open Drawer
        UiObject drawerButton = mDevice.findObject(new UiSelector().className("android.widget.ImageButton").descriptionContains("open"));
        try {
            if (drawerButton.exists() && drawerButton.isEnabled()) {
                drawerButton.click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }

        //Close drawer by selecting home fragment again
        UiObject homeButton = mDevice.findObject(new UiSelector().className("android.widget.CheckedTextView").text("Home"));
        try {
            if (homeButton.exists() && homeButton.isEnabled()) {
                homeButton.click();
            }
        }catch (UiObjectNotFoundException e){
            Log.d("CLOSEDRAWER ERROR: ", "failed to close drawer");
        }
        try{
            Thread.sleep(500);
        }catch(InterruptedException e) {
            //do nothing
        }
    }

    @Test
    public void navigateToQuizTest() {
        //Open Drawer
        UiObject drawerButton = mDevice.findObject(new UiSelector().className("android.widget.ImageButton").descriptionContains("open"));
        try {
            if (drawerButton.exists() && drawerButton.isEnabled()) {
                drawerButton.click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }

        //Close drawer by selecting home fragment again
        UiObject quizButton = mDevice.findObject(new UiSelector().className("android.widget.CheckedTextView").text("Quiz"));
        try {
            if (quizButton.exists() && quizButton.isEnabled()) {
                quizButton.click();
            }
        }catch (UiObjectNotFoundException e){
            Log.d("CLOSEDRAWER ERROR: ", "failed to close drawer");
        }
        try{
            Thread.sleep(500);
        }catch(InterruptedException e) {
            //do nothing
        }
    }

    @Test
    public void navigateToForumTest() {
        //Open Drawer
        UiObject drawerButton = mDevice.findObject(new UiSelector().className("android.widget.ImageButton").descriptionContains("open"));
        try {
            if (drawerButton.exists() && drawerButton.isEnabled()) {
                drawerButton.click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }

        //Close drawer by selecting home fragment again
        UiObject forumsButton = mDevice.findObject(new UiSelector().className("android.widget.CheckedTextView").text("Forums"));
        try {
            if (forumsButton.exists() && forumsButton.isEnabled()) {
                forumsButton.click();
            }
        }catch (UiObjectNotFoundException e){
            Log.d("CLOSEDRAWER ERROR: ", "failed to close drawer");
        }
        try{
            Thread.sleep(500);
        }catch(InterruptedException e) {
            //do nothing
        }
    }
}