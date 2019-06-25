package com.example.androidportfolio

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.weatherHttpResopnse.WeatherHttpResponseActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class WeatherHttpResponseActivityTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(WeatherHttpResponseActivity::class.java)

  @Test
  fun firstLayout() {
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
    onView(withText(R.string.desc_weather_http_response)).check(matches(isDisplayed()))
    onView(withId(R.id.weatherDetail)).check(matches(isDisplayed()))
  }

  // add test about a result of http request.
}
