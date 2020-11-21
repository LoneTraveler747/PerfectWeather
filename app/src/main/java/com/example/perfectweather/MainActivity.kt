package com.example.perfectweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.perfectweather.fragments.BaselineFragment
import com.example.perfectweather.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Timestamp
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      var  time = ("1605996452"+"000").toLong()
        var dt = DateUtils.formatDateTime(this, time , DateUtils.FORMAT_SHOW_TIME)
        Log.i("DT", dt)

        val homeFragment = HomeFragment()
        val baselineFragment = BaselineFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_baseline -> makeCurrentFragment(homeFragment)
                R.id.ic_baseline_brightness -> makeCurrentFragment(baselineFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}
