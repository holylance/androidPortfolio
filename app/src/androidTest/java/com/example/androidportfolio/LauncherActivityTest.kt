package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LauncherActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(LauncherActivity::class.java)

  @Test
  fun firstLayout() {
    // check Launcher activity.
    onView(withText(R.string.app_title)).check(matches(isDisplayed()))
    onView(withId(R.id.textViewLauncher)).check(matches(isDisplayed()))
    onView(withId(R.id.launcherLayout)).check(matches(isDisplayed()))
  }

  @Test
  fun touchAnyScreen() {
    // touch the activity and go to lobby activity.
    onView(withId(R.id.launcherLayout))
      .check(matches(isDisplayed()))
      .perform(click())

    // check Lobby activity.
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withId(R.id.list_fragments)).check(matches(isDisplayed()))
  }
}
