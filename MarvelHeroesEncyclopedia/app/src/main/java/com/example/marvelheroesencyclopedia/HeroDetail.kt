package com.example.marvelheroesencyclopedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.marvelheroesencyclopedia.databinding.ActivityHeroDetailBinding

class HeroDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME             = "extra_hero_name"
        const val EXTRA_IMAGE            = "extra_hero_image"
        const val EXTRA_SUBTITLE         = "extra_hero_subtitle"
        const val EXTRA_DESC             = "extra_hero_desc"
        const val EXTRA_ALTER_EGO        = "extra_alter_ego"
        const val EXTRA_AFFILIATION      = "extra_affiliation"
        const val EXTRA_FIRST_APPEARANCE = "extra_first_appearance"
        const val EXTRA_SERIES           = "extra_series"
        const val EXTRA_HEIGHT           = "extra_height"
        const val EXTRA_POWERS           = "extra_powers"
    }

    private lateinit var binding: ActivityHeroDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name          = intent.getStringExtra(EXTRA_NAME)               ?: "Unknown Hero"
        val imageUrl      = intent.getStringExtra(EXTRA_IMAGE)              ?: ""
        val subtitle      = intent.getStringExtra(EXTRA_SUBTITLE)           ?: ""
        val desc          = intent.getStringExtra(EXTRA_DESC)               ?: ""
        val alterEgo      = intent.getStringExtra(EXTRA_ALTER_EGO)          ?: ""
        val affiliation   = intent.getStringExtra(EXTRA_AFFILIATION)        ?: ""
        val firstApp      = intent.getStringExtra(EXTRA_FIRST_APPEARANCE)   ?: ""
        val series        = intent.getStringExtra(EXTRA_SERIES)             ?: ""
        val height        = intent.getStringExtra(EXTRA_HEIGHT)             ?: ""
        val powers        = intent.getStringExtra(EXTRA_POWERS)             ?: ""

        binding.detailName.text           = name
        binding.detailSubtitle.text       = subtitle
        binding.alterEgoValue.text        = alterEgo
        binding.affiliationValue.text     = affiliation
        binding.firstAppearanceValue.text = firstApp
        binding.seriesValue.text          = series
        binding.heightValue.text          = height
        binding.powersValue.text          = powers
        binding.detailDescription.text    = desc

        Glide.with(this)
            .load(imageUrl)
            .centerCrop()
            .into(binding.detailImage)
    }
}
