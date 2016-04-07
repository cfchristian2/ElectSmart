package com.electsmart.electsmart.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import com.electsmart.electsmart.Activities.TabActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class CurrentEventsNavTest {

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
    public void OpenCurrentEventsArticleTest() {
        //Open More options menu
        UiObject currentEventsTab = mDevice.findObject(new UiSelector().className("android.support.v7.app.ActionBar$Tab").index(2));
        try {
            if (currentEventsTab.exists() && currentEventsTab.isEnabled()) {
                currentEventsTab.click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e) {
            //do nothing
        }

        //Select first article
        UiObject article = mDevice.findObject(new UiSelector()
                .className("android.widget.ListView")
                .index(1)
                .childSelector(new UiSelector()
                        .index(0)
                        .className("android.widget.RelativeLayout")
                        .resourceId("com.electsmart.electsmart:id/currentEventsArticlePeek")));
        try {
            if (article.exists() && article.isEnabled()) {
                article.click();
            }
            else{
                System.exit(1);
            }
        }catch (UiObjectNotFoundException e){
            Log.d("SETTINGS ERROR: ", "Couldn't find settings option");
        }

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e) {
            //do nothing
        }
    }

    @Test
    public void OpenPollingPlaceTest() {
        //Open More options menu
        UiObject pollingPlaceButton = mDevice.findObject(new UiSelector().className("android.widget.TextView").resourceId("com.electsmart.electsmart:id/action_polling_place"));
        try {
            if (pollingPlaceButton.exists() && pollingPlaceButton.isEnabled()) {
                pollingPlaceButton.click();
            }
        }catch (UiObjectNotFoundException e){
            System.exit(1);
        }
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            //do nothing
        }
    }
}