package com.example.androidportfolio.lobby

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.androidportfolio.R

class LobbyAdapter(
  private var mData: List<String>,
  private val listener : OnItemClickListener
): RecyclerView.Adapter<LobbyAdapter.ViewHolder>() {
  inner class ViewHolder(
    itemView: View
  ) : RecyclerView.ViewHolder(itemView) {
    private var textView1: TextView = itemView.findViewById(R.id.text1)

    fun bind(item: String, listener: OnItemClickListener) {
      textView1.text = item
      itemView.setOnClickListener(View.OnClickListener {
        listener.onItemClick(item)
      })
    }
  }

  interface OnItemClickListener {
    fun onItemClick(item: String)
  }

  // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val context = parent.context
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    val view = inflater.inflate(R.layout.recyclerview_basic_item, parent, false)

    return this.ViewHolder(view)
  }

  // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(mData[position], listener)
  }

  override fun getItemCount(): Int {
    return mData.size
  }
}
