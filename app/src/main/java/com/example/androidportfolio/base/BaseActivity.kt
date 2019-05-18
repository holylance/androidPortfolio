package com.example.androidportfolio.base

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.androidportfolio.R
import com.example.androidportfolio.recycleview.RecycleViewBasicActivity
import com.example.androidportfolio.viewpager.ViewPagerActivity
import kotlinx.android.synthetic.main.activity_launcher.*

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
      android.R.id.home -> finish()
      R.id.action_home -> startActivity(Intent(this, ViewPagerActivity::class.java))
      R.id.action_recycleview -> startActivity(Intent(this, RecycleViewBasicActivity::class.java))
    }
    return true
  }
}