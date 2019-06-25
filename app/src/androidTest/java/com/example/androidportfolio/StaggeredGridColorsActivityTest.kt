package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.staggeredgridcolors.StaggeredGridColorsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class StaggeredGridColorsActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(StaggeredGridColorsActivity::class.java)

  @Test
  fun firstLayout() {
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withId(R.id.staggered_grid_color)).check(matches(isDisplayed()))
  }
}
