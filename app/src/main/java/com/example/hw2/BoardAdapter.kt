package com.example.hw2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ItemBoardBinding
import dagger.Provides
import javax.inject.Inject

class BoardAdapter (val context:Context, val navController: NavController ) : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
    private val data = arrayListOf<Board>()

/*

@Inject
private lateinit var prefs: Prefs
*/

    inner class BoardViewHolder(private var binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.lottione.setAnimation(board.lottie)
            binding.textTittle.text = board.title
            binding.textDesc.text = board.description
            if (data.lastIndexOf(   board) == data.lastIndex){
                binding.btnStart.visibility = View.VISIBLE

            } else {
                binding.btnStart.visibility = View.INVISIBLE

             /*  binding.btnStart.setOnClickListener {
                  prefs.isShown()
                    navController.navigateUp()
               */

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        return BoardViewHolder(
            ItemBoardBinding.inflate
                (
                LayoutInflater.from
                    (parent.context), parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
    fun addItem(board: Board) {
        data.add(board)
    }


}