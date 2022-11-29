package com.challengesuperhero.framework.presentation.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.challengesuperhero.databinding.ItemSuperheroBinding
import com.challengesuperhero.domain.ImageResponse

class ImageListAdapter(
    private val listener: ImageListener
) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    private val listImageResponse = mutableListOf<ImageResponse>()

    fun setData(listImage: MutableList<ImageResponse>) {
        listImageResponse.addAll(listImage)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listImageResponse[position], position)
    }

    override fun getItemCount() = listImageResponse.size

    inner class ViewHolder(
        private val binding: ItemSuperheroBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(image: ImageResponse, position: Int) {
            binding.name.text = image.name
            Glide.with(binding.root).load(image.url).centerCrop().into(binding.image)
            binding.root.setOnClickListener {
                listener.clickImage(image)
            }
        }
    }

    interface ImageListener {
        fun clickImage(image: ImageResponse)
    }
}