package com.example.androidportfolio

import android.support.v4.view.PagerAdapter
import android.view.ViewGroup
import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View

class TextViewPagerAdapter(
  private var mContext: Context
): PagerAdapter() {
  override fun instantiateItem(container: ViewGroup, position: Int): Any {
    var view: View? = null

    val inflater = mContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    view = inflater.inflate(R.layout.page_v, container, false)

    val textView = view!!.findViewById(R.id.title) as TextView
    textView.text = "TEXT $position"

    // 뷰페이저에 추가.
    container.addView(view)

    return view
  }

  override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
    container.removeView(`object` as View)
  }

  override fun getCount(): Int {
    return 10
  }

  override fun isViewFromObject(view: View, `object`: Any): Boolean {
    return view === `object` as View
  }
}
