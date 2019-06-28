package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.lobby.LobbyActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.contrib.RecyclerViewActions
import com.example.androidportfolio.lobby.LobbyAdapter


@RunWith(AndroidJUnit4::class)
@LargeTest
class LobbyActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(LobbyActivity::class.java)

  @Test
  fun firstLayout() {
    // check Lobby activity.
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withId(R.id.listActivities)).check(matches(isDisplayed()))
  }

  // Please make some new test which check each list items.
  @Test
  fun pushFirstElementOnList() {
    onView(withId(R.id.listActivities))
      .perform(RecyclerViewActions.actionOnItemAtPosition<LobbyAdapter.ViewHolder>(0, click()))

    // position 0 means it goes to Mycareers Activity.
    onView(withId(R.id.viewPager)).check(matches(isDisplayed()))
  }
}
