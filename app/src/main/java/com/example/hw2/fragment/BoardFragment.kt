package com.example.hw2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.example.hw2.Board
import com.example.hw2.BoardAdapter
import com.example.hw2.R
import com.example.hw2.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BoardFragment  : Fragment() {
    private lateinit var binding: FragmentBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter( requireContext(), findNavController() )
        binding.viewPager.adapter = adapter
        binding.viewPager.adapter = adapter
        binding.dots.setViewPager2(binding.viewPager)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner) {
            activity?.finish()

        }
        adapter.addItem(
            Board(
                R.raw.lottione,
                "Have a good time",
                "You should take the time to help those who need you"
            )
        )
        adapter.addItem(
            Board(
                R.raw.lotti2,
                "Cherishing love",
                "It is now no longer possible for you to cherish love"
            )
        )
        adapter.addItem(
            Board(
                R.raw.lotti3,
                "Have a breakup?",
                "We have made the correction for you don't worry\nMaybe someone is waiting for you!"
            )
        )
        adapter.addItem(Board(R.raw.lotti4, "", "It's Fans and Many more"))

    }
}