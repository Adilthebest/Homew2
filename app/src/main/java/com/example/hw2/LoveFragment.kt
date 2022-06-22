package com.example.hw2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw2.databinding.FragmentLoveBinding
import com.example.hw2.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoveFragment : Fragment() {

private lateinit var binding: FragmentLoveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoveBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initClic()
    }

    private fun initClic() {
        with(binding){
            bTnNext.setOnClickListener{
                val firstname = editFname.text.toString()
                val secondname = editSname.text.toString()
                App.loveApi.getPercentage(firstname,secondname).enqueue(object :
                    Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful)
Log.e("ololo", "Response:${response.body()?.result}",)
                        val bundle = Bundle()

                        bundle.putString("firstName", response.body()?.firstname)
                        bundle.putString("secondName", response.body()?.secondname)
                        bundle.putString("percentage", response.body()?.persenteg)
                        bundle.putString("result", response.body()?.result)

                        findNavController().navigate(R.id.blankFragment, bundle)

                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure:${t.message}",)


                    }
                })
            }

        }

    }
}
