package com.electsmart.electsmart;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Scott on 3/17/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NavigateToMainHeadlineTest {

    @Test
    public void moveToCurrentEventsNews(){
        Espresso.onView(ViewMatchers.withId(R.id.MainEventPeek)).perform(ViewActions.click());
    }
}
