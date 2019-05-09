package com.example.androidportfolio

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecycleViewBasicAdapter(
  private var mData: List<String>
): RecyclerView.Adapter<RecycleViewBasicAdapter.ViewHolder>() {
  inner class ViewHolder(
    itemView: View
  ) : RecyclerView.ViewHolder(itemView) {
    internal var textView1: TextView

    init {
      // 뷰 객체에 대한 참조. (hold strong reference)
      textView1 = itemView.findViewById(R.id.text1)
    }
  }

  // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewBasicAdapter.ViewHolder {
    val context = parent.context
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    val view = inflater.inflate(R.layout.recyclerview_basic_item, parent, false)

    return this.ViewHolder(view)
  }

  // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
  override fun onBindViewHolder(holder: RecycleViewBasicAdapter.ViewHolder, position: Int) {
    val text = mData[position]
    holder.textView1.setText(text)
  }

  override fun getItemCount(): Int {
    return mData.size
  }
}
