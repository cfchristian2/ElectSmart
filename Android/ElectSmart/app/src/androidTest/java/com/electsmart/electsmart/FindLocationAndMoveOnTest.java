package com.electsmart.electsmart;

import android.content.ComponentName;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.electsmart.electsmart.Activities.MainActivity;
import com.electsmart.electsmart.Activities.TabActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FindLocationAndMoveOnTest {

    private PreferencesManager mPrefsManager;

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<MainActivity>(
            MainActivity.class){
        @Override
        protected void beforeActivityLaunched() {
            //clear preferences
            PreferencesManager.initializeInstance(InstrumentationRegistry.getTargetContext());
            mPrefsManager = PreferencesManager.getInstance();
            mPrefsManager.clear();

            super.beforeActivityLaunched();
        }
    };

    @Test
    public void moveToNextActivity() {
        //checks that clicking the continue button will move to the TabActivity
        Espresso.onView(ViewMatchers.withId(R.id.continueButton)).perform(ViewActions.click());


        Intents.intended(IntentMatchers.hasComponent(new ComponentName(InstrumentationRegistry.getTargetContext(), TabActivity.class)));
    }
}
