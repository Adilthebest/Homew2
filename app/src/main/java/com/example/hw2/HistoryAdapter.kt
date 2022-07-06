package com.example.hw2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ItemBoardBinding
import com.example.hw2.databinding.ItemHistoryBinding
import com.example.hw2.model.LoveModel

class HistoryAdapter (private val list : List<LoveModel>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun Bind(loveModel: LoveModel) {
            binding.fname.text = loveModel.firstname
            binding.sname.text = loveModel.secondname


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.Bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
