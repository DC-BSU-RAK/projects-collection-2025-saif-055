package com.example.marvelheroesencyclopedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelheroesencyclopedia.databinding.ItemHeroBinding

class HeroesAdapter(
    private val items: List<Hero>,
    private val onClick: (Hero) -> Unit
) : RecyclerView.Adapter<HeroesAdapter.VH>() {

    inner class VH(private val binding: ItemHeroBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(hero: Hero) {
            binding.heroName.text = hero.name
            Glide.with(binding.heroThumbnail.context)
                .load(hero.thumbnailUrl)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.heroThumbnail)
            binding.root.setOnClickListener { onClick(hero) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemHeroBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size
}
