package com.example.hw2.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw2.App
import com.example.hw2.R
import com.example.hw2.databinding.FragmentLoveBinding
import com.example.hw2.model.LoveModel
import com.example.hw2.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding
    val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoveBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            bTnNext.setOnClickListener {
                val firstname = editFname.text.toString()
                val secondname = editSname.text.toString()
                viewModel.getLiveLoveViewModel(firstname, secondname).observe(viewLifecycleOwner,
                    Observer {
                        Log.e("ololo", "initClickers:${it}")

                    })
            }
        }
    }
}



