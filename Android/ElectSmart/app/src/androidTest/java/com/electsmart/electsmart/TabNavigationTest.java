package com.electsmart.electsmart;

import static android.support.test.espresso.Espresso.onView;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TabNavigationTest {

    @Rule
    public ActivityTestRule<TabActivity> mActivityRule = new ActivityTestRule<>(TabActivity.class);

    @Test
    public void homeFragmentShownTest() {
        onView(ViewMatchers.withId(R.id.Election)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void upcomingElectionsShownTest() {
        onView(Matchers.allOf(ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tabs)), ViewMatchers.withText("Upcoming Elections")))
                .perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.currentLocation))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void currentEventsShownTest() {
        onView(Matchers.allOf(ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tabs)), ViewMatchers.withText("Current Events")))
                .perform(ViewActions.click());
        onView(ViewMatchers.withId(R.id.editText))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
