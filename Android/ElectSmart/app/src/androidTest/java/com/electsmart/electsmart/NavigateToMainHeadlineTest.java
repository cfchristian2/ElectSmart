package com.electsmart.electsmart;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.electsmart.electsmart.Activities.TabActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;

/**
 * Created by Scott on 3/17/2016.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class NavigateToMainHeadlineTest {

    @Rule
    public ActivityTestRule<TabActivity> mActivityRule = new ActivityTestRule<>(TabActivity.class);
    @Test
    public void moveToCurrentEventsNews(){
        onView(ViewMatchers.withId(R.id.MainEventPeek)).perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.Article)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        //onView(ViewMatchers.withId(R.id))
            //    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
