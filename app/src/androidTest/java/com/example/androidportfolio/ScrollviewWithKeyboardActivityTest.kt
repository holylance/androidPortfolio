package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.scrollviewwithkeyboard.ScrollviewWithKeyboardActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ScrollviewWithKeyboardActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(ScrollviewWithKeyboardActivity::class.java)

  @Test
  fun firstLayout() {
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withId(R.id.sv_root)).check(matches(isDisplayed()))
    onView(withId(R.string.desc_scrollview_with_keyboard)).check(matches(isDisplayed()))
    onView(withId(R.mipmap.ic_launcher)).check(matches(isDisplayed()))
    onView(withId(R.string.edit_hint)).check(matches(isDisplayed()))
    onView(withId(R.string.button)).check(matches(isDisplayed()))
    onView(withId(R.string.desc_dummy_text_to_scroll)).check(matches(isDisplayed()))
  }

  // scroll view test.
}
