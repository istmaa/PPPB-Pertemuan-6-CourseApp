package com.example.courseapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.courseapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.tab_home)
                    tab.setIcon(R.drawable.ic_home)
                }
                1 -> {
                    tab.text = getString(R.string.tab_materi)
                    tab.setIcon(R.drawable.ic_materi)
                }
                2 -> {
                    tab.text = getString(R.string.tab_quiz)
                    tab.setIcon(R.drawable.ic_quiz)
                }
            }
        }.attach()

        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.topAppBar.setPadding(0, systemBars.top, 0, 0)
            binding.tabLayout.setPadding(0, 0, 0, systemBars.bottom)
            insets
        }
    }
}