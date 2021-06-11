package com.example.androidportfolio.lobby

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidportfolio.InstanceStateActivity
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.myCareers.MyCareersActivity
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.scrollviewwithkeyboard.ScrollviewWithKeyboardActivity
import com.example.androidportfolio.staggeredgridcolors.StaggeredGridColorsActivity
import com.example.androidportfolio.weatherHttpResopnse.WeatherHttpResponseActivity
import kotlinx.android.synthetic.main.activity_lobby.*

class LobbyActivity : BaseActivity() {
  companion object {
    enum class ActivityType(
      val typeName: String
    ) {
      MyCareers("MyCareers"),
      RecycleViewBasic("RecycleViewBasic"),
      ScrollviewWithKeyboard("ScrollviewWithKeyboard"),
      InstanceState("InstanceState"),
      StaggeredGridColors("StaggeredGridColors"),
      WeatherHttpResponse("WeatherHttpResponse"),
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_lobby)

    val list = ActivityType.values().map { it.typeName }

    listActivities.layoutManager = LinearLayoutManager(this)
    val adapter = LobbyAdapter(list, ItemClickListener(this))
    listActivities.adapter = adapter

    setUp()
  }

  inner class ItemClickListener(
    private val context: Context
  ): LobbyAdapter.OnItemClickListener {
    override fun onItemClick(item: String) {
      val intent = when(ActivityType.valueOf(item)) {
        ActivityType.RecycleViewBasic -> Intent(context, RecycleViewBasicActivity::class.java)
        ActivityType.ScrollviewWithKeyboard -> Intent(context, ScrollviewWithKeyboardActivity::class.java)
        ActivityType.InstanceState -> Intent(context, InstanceStateActivity::class.java)
        ActivityType.StaggeredGridColors -> Intent(context, StaggeredGridColorsActivity::class.java)
        ActivityType.WeatherHttpResponse -> Intent(context, WeatherHttpResponseActivity::class.java)
        else -> Intent(context, MyCareersActivity::class.java)
      }
      startActivity(intent)
    }
  }
}
