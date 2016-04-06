package com.electsmart.electsmart;

import static android.support.test.espresso.Espresso.onView;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.electsmart.electsmart.API.GoogleCivicInfo.Models.Candidate;
import com.electsmart.electsmart.Activities.ElectionActivity;
import com.electsmart.electsmart.Activities.TabActivity;
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
public class ElectionNavigationTest {

    @Rule
    public ActivityTestRule<ElectionActivity> mActivityRule = new ActivityTestRule<>(ElectionActivity.class, false, false);

    @Test
    public void ElectionActivityStarted() {
        List<String> openPositions = new ArrayList<String>();
        List<Candidate> candidates = new ArrayList<Candidate>();
        HashMap<String, List<Candidate>> candidatePositionMap = new HashMap<String, List<Candidate>>();

        //DUMMY DATA IN PLACE OF APIS
        for(int j = 0; j < 3; j++){
            candidates.add(new Candidate("Candidate " + j, "Democrat", null, null, "http://amiloszportraits.com/wp-content/uploads/2015/12/barack%20obama%20thumbs%20up%20meme-drunk-obama-thumbs-up.jpg", null, 0, null));
        }
        for(int i = 0; i < 5; i++){
            openPositions.add("Position " + i);
            candidatePositionMap.put(openPositions.get(i), candidates);
        }
        Election elec1 = new Election(01, 01, 2017, 0, "First Election", candidatePositionMap);
        Election elec2 = new Election(12, 31, 2017, 1, "Second Election", candidatePositionMap);
        Election elec3 = new Election(02, 02, 2018, 2, "Third Election", candidatePositionMap);
        Election elec4 = new Election(07, 16, 2017, 3, "My Birthday", candidatePositionMap);

        UpcomingElectionRow row1 = new UpcomingElectionRow(elec1, elec2);
        UpcomingElectionRow row2 = new UpcomingElectionRow(elec3, elec4);

        Intent intent = new Intent();
        intent.putExtra("election", row1.getLeft());
        mActivityRule.launchActivity(intent);

        //Click on parent group (Position)
        Espresso.onData(Matchers.allOf(Matchers.instanceOf(String.class), withPositionName("Position 0")))
                .inAdapterView(ViewMatchers.withId(R.id.expList))
                .perform(ViewActions.click());

        //Click on child (Candidate)
        Espresso.onData(Matchers.allOf(Matchers.instanceOf(Candidate.class), withCandidateName("Candidate 0")))
                .inAdapterView(ViewMatchers.withId(R.id.expList))
                .perform(ViewActions.click());

        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            //do nothing
        }
    }

    public static Matcher<Object> withPositionName(String name) {
        return withPositionName(Matchers.equalTo(name));
    }
    //private method that does the work of matching
    private static Matcher<Object> withPositionName(final Matcher<String> name) {
        return new BoundedMatcher<Object, String>(String.class) {
            @Override
            public boolean matchesSafely( final String actualObject) {
                // ****** ... the 'matches'. See below.
                // this requires the MyObjectWithItemAndSize to have an 'equals' method
                if( name.matches(actualObject) ) {
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("True should return if expectedCandidate contains same info as actualCandidate besides hashMap");
            }
        };
    }

    public static Matcher<Object> withCandidateName(String name) {
        return withCandidateName(Matchers.equalTo(name));
    }
    //private method that does the work of matching
    private static Matcher<Object> withCandidateName(final Matcher<String> name) {
        return new BoundedMatcher<Object, Candidate>(Candidate.class) {
            @Override
            public boolean matchesSafely( final Candidate actualObject) {
                // ****** ... the 'matches'. See below.
                // this requires the MyObjectWithItemAndSize to have an 'equals' method
                if( name.matches(actualObject.getName()) ) {
                    return true;
                } else {
                    return false;
                }
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("True should return if expectedCandidate contains same info as actualCandidate besides hashMap");
            }
        };
    }
}
