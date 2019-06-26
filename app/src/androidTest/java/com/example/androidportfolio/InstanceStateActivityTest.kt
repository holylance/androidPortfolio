package com.example.androidportfolio

import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
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

  @Test
  fun pushCountButton() {
    onView(withId(R.id.text_view_count)).check(matches(withText("0")))

    // touch the activity and go to lobby activity.
    onView(withId(R.id.button_plus)).perform(click())

    onView(withId(R.id.text_view_count)).check(matches(withText("1")))
  }

  @Test
  fun pauseAndRestoreApp() {
    onView(withId(R.id.text_view_count)).check(matches(withText("0")))
    onView(withId(R.id.edit_instance_state)).check(matches(withText("")))

    // push plus button three times.
    (0..2).forEach {
      onView(withId(R.id.button_plus)).perform(click())
    }
    // enter some text on edit.
    onView(withId(R.id.edit_instance_state)).perform(clearText(), typeText("test"))

    onView(withId(R.id.text_view_count)).check(matches(withText("3")))
    onView(withId(R.id.edit_instance_state)).check(matches(withText("test")))

    // pause and resume this app.
    mActivityRule.activity.runOnUiThread {
      getInstrumentation().callActivityOnPause(mActivityRule.activity)
      getInstrumentation().callActivityOnResume(mActivityRule.activity)
    }

    // the same result with before.
    onView(withId(R.id.text_view_count)).check(matches(withText("3")))
    onView(withId(R.id.edit_instance_state)).check(matches(withText("test")))
  }
}
