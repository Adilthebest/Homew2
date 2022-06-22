package com.example.hw2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw2.databinding.FragmentBlankBinding
import com.example.hw2.databinding.FragmentLoveBinding

class BlankFragment : Fragment() {
private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initClick()
    argumentsAndSet()
    }
    private fun initClick() {
        binding.tryAgainBtn.setOnClickListener {
            findNavController().navigateUp()

        }
    }
        private fun argumentsAndSet() {
            val firstName = arguments?.getString("firstName")
            val secondName = arguments?.getString("secondName")
            val percent = arguments?.getString("percentage")
            val result = arguments?.getString("result")


            binding.firstName.text = firstName
            binding.secondName.text = secondName
            binding.percent.text = "$percent%"
            binding.result.text = result

        }
    }

