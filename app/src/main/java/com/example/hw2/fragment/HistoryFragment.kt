package com.example.hw2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.viewbinding.ViewBinding
import com.example.hw2.App
import com.example.hw2.HistoryAdapter
import com.example.hw2.R
import com.example.hw2.core.BaseFragment
import com.example.hw2.databinding.FragmentHistoryBinding


class HistoryFragment: BaseFragment<FragmentHistoryBinding>() {
  lateinit var adapter:HistoryAdapter
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return super.onCreateView(inflater, container, savedInstanceState)
  }

  override fun inflate(): FragmentHistoryBinding {
    return FragmentHistoryBinding.inflate(layoutInflater)

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
observeHistory()
  }



  private fun observeHistory() {
    App.dp.historyDao().getAll().observe(viewLifecycleOwner) { data ->
      Log.e("ololo", "onViewCreated$data")
      adapter = HistoryAdapter(data)
      binding.recucleview.adapter = this.adapter
    }
  }
}
