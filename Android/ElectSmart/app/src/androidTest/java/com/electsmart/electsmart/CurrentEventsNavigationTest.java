package com.electsmart.electsmart;

import static android.support.test.espresso.Espresso.onView;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.electsmart.electsmart.API.Faroo.Models.FarooArticle;
import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Activities.ElectionActivity;
import com.electsmart.electsmart.Activities.MainActivity;
import com.electsmart.electsmart.Activities.TabActivity;
import com.electsmart.electsmart.Adapters.UpcomingElectionsAdapter;
import com.electsmart.electsmart.Models.Election;
import com.electsmart.electsmart.Models.UpcomingElectionRow;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CurrentEventsNavigationTest extends ActivityUnitTestCase<TabActivity> {

    public CurrentEventsNavigationTest() {
        super(TabActivity.class);
    }
    @Rule
    public IntentsTestRule<TabActivity> mActivityRule = new IntentsTestRule<TabActivity>(
            TabActivity.class);

    @Test
    public void upcomingElectionsSelectElection() {

        //Find Upcoming Elections Tab and select it
        onView(Matchers.allOf(ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tabs)), ViewMatchers.withText("Current Events")))
                .perform(ViewActions.click());

        Espresso.onData(Matchers.allOf()).inAdapterView(ViewMatchers.withId(R.id.currentEventsList))
                .atPosition(0)
                .perform(ViewActions.click());
    }

    /*public static Matcher<Object> UpcomingElectionRowHasContent( UpcomingElectionRow expectedRow) {
        return UpcomingElectionRowHasContent(Matchers.equalTo(expectedRow));
    }
    //private method that does the work of matching
    private static Matcher<Object> UpcomingElectionRowHasContent(final Matcher<UpcomingElectionRow> expectedObject) {
        return new BoundedMatcher<Object, UpcomingElectionRow>(UpcomingElectionRow.class) {
            @Override
            public boolean matchesSafely( final UpcomingElectionRow actualObject) {
                // ****** ... the 'matches'. See below.
                // this requires the MyObjectWithItemAndSize to have an 'equals' method
                if( expectedObject.matches(actualObject) ) {
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("True should return if expectedRow contains same info as actualRow besides hashMap");
            }
        };
    }*/
}