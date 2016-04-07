package com.electsmart.electsmart;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.electsmart.electsmart.Activities.TabActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Scott  on 4/6/2016.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)

public class HomeNavigationTest extends ApplicationTestCase<Application> {
    public HomeNavigationTest() {
        super(Application.class);
    }
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
        UiObject homeTab = mDevice.findObject(new UiSelector().className("android.support.v7.app.ActionBar$Tab").index(0));
        try {
            if (homeTab.exists() && homeTab.isEnabled()) {
                homeTab.click();
            }
        } catch (UiObjectNotFoundException e) {
            System.exit(1);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //do nothing
        }

        UiObject mainArticle = mDevice.findObject(new UiSelector().className("android.widget.RelativeLayout")
                .resourceId("com.electsmart.electsmart:id/MainEventPeek");
        try {
            if (mainArticle.exists() && mainArticle.isEnabled()) {
                mainArticle.click();
            }
            else{
                System.exit(1);
            }
        }catch (UiObjectNotFoundException e){
            Log.d("SETTINGS ERROR: ", "Couldn't find settings option");
        }
        catch (Exception ex){
            Log.d("error", "some error");
        }

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e) {
            //do nothing
        }
    }
}
