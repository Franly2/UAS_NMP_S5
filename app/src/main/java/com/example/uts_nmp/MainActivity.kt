package com.example.uts_nmp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.uts_nmp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        // BottomNav rubah ViewPager
        binding.nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemHome -> binding.viewPager.currentItem = 0
                R.id.itemMyFriends -> binding.viewPager.currentItem = 1
                R.id.itemSettings -> binding.viewPager.currentItem = 2
            }
            true
        }

        // ViewPager rubah BottomNav
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when (position) {
                        0 -> binding.nav.selectedItemId = R.id.itemHome
                        1 -> binding.nav.selectedItemId = R.id.itemMyFriends
                        2 -> binding.nav.selectedItemId = R.id.itemSettings
                    }
                }
            }
        )





    }
}
