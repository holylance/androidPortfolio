package com.example.androidportfolio.base

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.androidportfolio.InstanceStateActivity
import com.example.androidportfolio.R
import com.example.androidportfolio.lobby.LobbyActivity
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.scrollviewwithkeyboard.ScrollviewWithKeyboardActivity
import com.example.androidportfolio.myCareers.MyCareersActivity
import com.example.androidportfolio.staggeredgridcolors.StaggeredGridColorsActivity
import kotlinx.android.synthetic.main.activity_lobby.*

open class BaseActivity: AppCompatActivity() {

  protected fun setUp() {
    // set tool bar.
    app_toolbar.setTitleTextColor(Color.WHITE)
    setSupportActionBar(app_toolbar)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.appbar_action, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId) {
      android.R.id.home -> finish() // back button in menu.
      R.id.action_home -> startActivity(Intent(this, LobbyActivity::class.java))
      R.id.action_my_careers -> startActivity(Intent(this, MyCareersActivity::class.java))
      R.id.action_recycleview -> startActivity(Intent(this, RecycleViewBasicActivity::class.java))
      R.id.action_scroll_view_with_keyboard -> startActivity(Intent(this, ScrollviewWithKeyboardActivity::class.java))
      R.id.action_instance_state -> startActivity(Intent(this, InstanceStateActivity::class.java))
      R.id.action_staggered_grid_colors -> startActivity(Intent(this, StaggeredGridColorsActivity::class.java))
    }
    return true
  }
}
