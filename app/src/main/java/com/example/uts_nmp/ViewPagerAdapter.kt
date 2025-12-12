package com.example.uts_nmp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ListFragment.newInstance("all")
            1 -> ListFragment.newInstance("friends")
            2 -> SettingsFragment()
            else -> ListFragment.newInstance("all")
        }
    }
}
