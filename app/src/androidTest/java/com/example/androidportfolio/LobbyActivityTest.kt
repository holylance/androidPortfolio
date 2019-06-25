package com.example.androidportfolio

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.lobby.LobbyActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LobbyActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(LobbyActivity::class.java)

  @Test
  fun firstLayout() {
    // check Lobby activity.
    Espresso.onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    Espresso.onView(withId(R.id.listActivities)).check(matches(isDisplayed()))
  }

  // Please make some new test which check each list items.
}
