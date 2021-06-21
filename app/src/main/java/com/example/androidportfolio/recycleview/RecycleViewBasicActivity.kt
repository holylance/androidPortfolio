package com.example.androidportfolio.recycleview

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidportfolio.R
import com.example.androidportfolio.base.BaseActivity
import com.example.androidportfolio.databinding.ActivityRecycleViewBasicBinding
import com.example.androidportfolio.util.viewBinding

class RecycleViewBasicActivity : BaseActivity(R.layout.activity_recycle_view_basic) {

    private val binding by viewBinding(ActivityRecycleViewBasicBinding::bind)

    inner class ItemClickListener(
        private val context: Context
    ) : RecycleViewBasicAdapter.OnItemClickListener {
        override fun onItemClick(item: String) {
            val intent = Intent(context, ListItemActivity::class.java)
            intent.putExtra(strTextDetail, item)
            startActivityForResult(intent, nRequestTypeNoResult)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val list = mutableListOf<String>()
        for (i in 0..99) {
            list += String.format("TEXT %d", i)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecycleViewBasicAdapter(list, ItemClickListener(this))
        binding.recyclerView.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            nRequestTypeNoResult -> if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        const val strTextDetail = "textDetail"
        const val nRequestTypeNoResult = 1000
    }
}
