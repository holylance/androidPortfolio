package com.example.androidportfolio

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
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
    onView(withId(R.id.app_toolbar)).check(matches(isDisplayed()))
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
  fun pushStaggeredGridColors() {

  }

  @Test
  fun pushWeatherHttpResponse() {

  }
}
