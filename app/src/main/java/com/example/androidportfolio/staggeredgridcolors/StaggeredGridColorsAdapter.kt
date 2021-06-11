package com.example.androidportfolio.staggeredgridcolors

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidportfolio.R
import java.util.*

class StaggeredGridColorsAdapter(
  private var mData: List<String>
): RecyclerView.Adapter<StaggeredGridColorsAdapter.ViewHolder>() {
  private val mRandom: Random = Random()

  inner class ViewHolder(
    itemView: View
  ) : RecyclerView.ViewHolder(itemView) {
    var textView1: TextView = itemView.findViewById(R.id.textView1)

    fun bind(item: String) {
      textView1.text = item
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaggeredGridColorsAdapter.ViewHolder {
    val context = parent.context
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    val view = inflater.inflate(R.layout.color_card_view, parent, false)

    return this.ViewHolder(view)
  }

  override fun onBindViewHolder(holder: StaggeredGridColorsAdapter.ViewHolder, position: Int) {
    holder.bind(mData[position])
    // Set a random height for TextView
    holder.textView1.height = getRandomIntInRange(450,175)
    // Set a random color for TextView background
    holder.textView1.setBackgroundColor(getRandomHSVColor())
  }

  override fun getItemCount(): Int {
    return mData.size
  }

  private fun getRandomIntInRange(nMax: Int, nMin: Int): Int {
    return mRandom.nextInt(nMax - nMin ) + nMin
  }

  private fun getRandomHSVColor(): Int {
    // Generate a random hue value between 0 to 360
    val hue = mRandom.nextInt(361)
    // We make the color depth full
    val saturation = 1.0f
    // We make a full bright color
    val value = 1.0f
    // We avoid color transparency
    val alpha = 255
    // Finally, generate the color
    // Return the color
    return Color.HSVToColor(alpha, floatArrayOf(hue.toFloat(), saturation, value))
  }
}
