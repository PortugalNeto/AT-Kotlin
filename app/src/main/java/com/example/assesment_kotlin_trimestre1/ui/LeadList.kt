package com.example.assesment_kotlin_trimestre1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.assesment_kotlin_trimestre1.R

class LeadList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lead_list)
        findViewById<ViewPager2>(R.id.viewPager).adapter = ScreenSlidePagerAdapter(this)
    }

    class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 1

        override fun createFragment(position: Int): Fragment = ListFragment()
    }
}