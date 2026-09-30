package com.example.courseapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.courseapp.databinding.ActivityDetailMateriBinding

class DetailMateriActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NUMBER = "extra_number"
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_OVERVIEW = "extra_overview"
        const val EXTRA_CONCEPTS = "extra_concepts"
        const val EXTRA_PRACTICE = "extra_practice"
        const val EXTRA_SUMMARY = "extra_summary"
    }

    private lateinit var binding: ActivityDetailMateriBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailMateriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = intent.getStringExtra(EXTRA_NUMBER) ?: "01"
        val title = intent.getStringExtra(EXTRA_TITLE) ?: ""
        val overview = intent.getStringExtra(EXTRA_OVERVIEW) ?: ""
        val concepts = intent.getStringArrayListExtra(EXTRA_CONCEPTS) ?: arrayListOf()
        val practice = intent.getStringExtra(EXTRA_PRACTICE) ?: ""
        val summary = intent.getStringExtra(EXTRA_SUMMARY) ?: ""

        binding.topAppBarDetail.title = "${getString(R.string.detail_module_prefix)} $number"
        binding.topAppBarDetail.setNavigationOnClickListener {
            finish()
        }

        binding.tvDetailNumberBadge.text = "${getString(R.string.detail_module_prefix)} $number"
        binding.tvDetailTitle.text = title
        binding.tvDetailOverview.text = overview
        binding.tvDetailPractice.text = practice
        binding.tvDetailSummary.text = summary

        val formattedConcepts = concepts.joinToString(separator = "\n\n") { "• $it" }
        binding.tvDetailConcepts.text = formattedConcepts

        binding.btnDetailBack.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.detailRootLayout) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.topAppBarDetail.setPadding(0, systemBars.top, 0, 0)
            binding.scrollDetail.setPadding(0, 0, 0, systemBars.bottom)
            insets
        }
    }
}
