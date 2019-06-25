package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView
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
class InstanceStateActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(InstanceStateActivity::class.java)

  @Test
  fun firstLayout() {
    // check tool bar in InstanceStateActivity.
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withText(R.string.desc_instance_state)).check(matches(isDisplayed()))
    onView(withId(R.id.text_view_count)).check(matches(isDisplayed()))
    onView(withId(R.id.button_plus)).check(matches(isDisplayed()))
    onView(withId(R.id.edit_instance_state)).check(matches(isDisplayed()))
  }

  // push button plus.

  // pause this app.

  // restore this app.
}
