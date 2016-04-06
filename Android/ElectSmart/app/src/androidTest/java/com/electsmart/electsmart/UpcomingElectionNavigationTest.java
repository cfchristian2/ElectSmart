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
public class UpcomingElectionNavigationTest extends ActivityUnitTestCase<TabActivity> {

    public UpcomingElectionNavigationTest() {
        super(TabActivity.class);
    }

    //Start activity before each test, terminated after each test
    /*@Rule
    public ActivityTestRule<TabActivity> mActivityRule = new ActivityTestRule<>(TabActivity.class);*/


    @Rule
    public IntentsTestRule<TabActivity> mActivityRule = new IntentsTestRule<TabActivity>(
            TabActivity.class);

    @Test
    public void upcomingElectionsSelectElection() {

        //Find Upcoming Elections Tab and select it
        onView(Matchers.allOf(ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tabs)), ViewMatchers.withText("Upcoming Elections")))
                .perform(ViewActions.click());

        //Create Dummy data that is currently hardcoded in app....
        List<String> openPositions = new ArrayList<String>();
        List<Candidate> candidates = new ArrayList<Candidate>();
        HashMap<String, List<Candidate>> candidatePositionMap = new HashMap<String, List<Candidate>>();

        for (int j = 0; j < 3; j++) {
            candidates.add(new Candidate("Candidate " + j, "Democrat", null, null, "http://amiloszportraits.com/wp-content/uploads/2015/12/barack%20obama%20thumbs%20up%20meme-drunk-obama-thumbs-up.jpg", null, 0, null));
        }
        for (int i = 0; i < 5; i++) {
            openPositions.add("Position " + i);
            candidatePositionMap.put(openPositions.get(i), candidates);
        }
        Election elec1 = new Election(01, 01, 2017, 0, "First Election", candidatePositionMap);
        Election elec2 = new Election(12, 31, 2017, 1, "Second Election", candidatePositionMap);

        UpcomingElectionRow row1 = new UpcomingElectionRow(elec1, elec2);

        // register ElectionActivity as it need to be monitored.
        Log.d("debug", "Class name: " + ElectionActivity.class.getName());

        //Find first row and select left election
        Espresso.onData(Matchers.allOf(Matchers.instanceOf(UpcomingElectionRow.class), UpcomingElectionRowHasContent(row1)))
                .inAdapterView(ViewMatchers.withId(R.id.upcomingElectionList))
                .onChildView(ViewMatchers.withId(R.id.leftElection))
                .perform(ViewActions.click());

        //Check activity started
        Intents.intended(IntentMatchers.hasComponent(new ComponentName(InstrumentationRegistry.getTargetContext(), ElectionActivity.class)));
    }

    public static Matcher<Object> UpcomingElectionRowHasContent( UpcomingElectionRow expectedRow) {
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
    }
}