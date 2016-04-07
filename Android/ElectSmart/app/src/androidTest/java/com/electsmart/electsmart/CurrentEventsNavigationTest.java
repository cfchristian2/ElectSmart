package com.electsmart.electsmart;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import com.electsmart.electsmart.Activities.TabActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;

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
    public void currentEventsSelect() {

        //Find Upcoming Elections Tab and select it
        onView(Matchers.allOf(ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.tabs)), ViewMatchers.withText("Current Events")))
                .perform(ViewActions.click());

        Espresso.onData(Matchers.allOf()).inAdapterView(ViewMatchers.withId(android.R.id.list))
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