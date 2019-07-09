package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView

import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressBack
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.recycleview.RecycleViewBasicAdapter
import com.example.androidportfolio.util.ToastMatcher
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RecycleViewBasicActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(RecycleViewBasicActivity::class.java)

  @Test
  fun firstLayout() {
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
  }

  // item click event test.
  @Test
  fun pushFirstElementOnList() {
    onView(withId(R.id.recyclerView))
      .perform(RecyclerViewActions.actionOnItemAtPosition<RecycleViewBasicAdapter.ViewHolder>(0, click()))

    // position 0 means it goes to ListItem Activity.
    onView(withId(R.id.imageViewDetail)).check(matches(isDisplayed()))
    onView(withId(R.id.textViewDetail)).check(matches(isDisplayed()))
    onView(withId(R.id.buttonDetail)).check(matches(isDisplayed()))

    // get result from child activity.
    onView(withId(R.id.buttonDetail)).perform(click())

    onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))

    // check toast.
    onView(withText("TEXT 0"))
      .inRoot(ToastMatcher())
      .check(matches(isDisplayed()))
  }

  // click back button on device.
  @Test
  fun pushBackButtonOnDevice() {
    onView(withId(R.id.recyclerView))
      .perform(RecyclerViewActions.actionOnItemAtPosition<RecycleViewBasicAdapter.ViewHolder>(0, click()))

    onView(isRoot()).perform(pressBack())

    onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
  }

  // click back button on tool bar.
  @Test
  fun pushBackButtonOnToolBar() {
    onView(withId(R.id.recyclerView))
      .perform(RecyclerViewActions.actionOnItemAtPosition<RecycleViewBasicAdapter.ViewHolder>(0, click()))

    // click back button.
    //onView(withId(android.R.id.home))
    //  .check(matches(isDisplayed()))
    //  .perform(click())

    //onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
  }
}
