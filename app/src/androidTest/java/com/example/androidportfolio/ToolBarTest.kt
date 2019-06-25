package com.example.androidportfolio

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.androidportfolio.lobby.LobbyActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ToolBarTest {
  @get:Rule
  val mActivityRule = ActivityTestRule(LobbyActivity::class.java)

  @Test
  fun firstLayout() {
    // check tool bar in Lobby Activity.
    Espresso.onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
  }

  @Test
  fun pushHomeButton() {

  }

  @Test
  fun pushMyCareers() {

  }

  @Test
  fun pushRecycleView() {

  }

  @Test
  fun pushScrollViewWithKeyboard() {

  }

  @Test
  fun pushInstanceState() {

  }

  @Test
  fun pushStaggeredGridColors() {

  }

  @Test
  fun pushWeatherHttpResponse() {

  }
}
