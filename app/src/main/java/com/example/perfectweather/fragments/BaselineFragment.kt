package com.example.perfectweather.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.perfectweather.R

class BaselineFragment: Fragment(){
    lateinit var shared: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        shared = requireActivity().getSharedPreferences("Test", Context.MODE_PRIVATE)
        var City = shared.all
        return inflater.inflate(R.layout.fragment_baseline, container, false)
    }
}