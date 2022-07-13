package com.example.hw2.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.system.Os.rename
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw2.App
import com.example.hw2.R
import com.example.hw2.core.BaseFragment
import com.example.hw2.databinding.FragmentHistoryBinding
import com.example.hw2.model.LoveApi
import com.example.hw2.model.LoveModel
import java.nio.file.Files.delete
import javax.inject.Inject


class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
  lateinit var adapter: HistoryAdapter
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

rename()
      }
    }


  private fun rename() {
    adapter.onClick = {
      val bundle = Bundle()
      bundle.putString("key1", it.firstname)
      findNavController().navigate(R.id.loveFragment, bundle)
    }
  }
}
