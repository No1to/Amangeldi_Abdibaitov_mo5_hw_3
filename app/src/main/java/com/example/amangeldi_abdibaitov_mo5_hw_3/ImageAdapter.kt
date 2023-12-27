package com.example.amangeldi_abdibaitov_mo5_hw_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.amangeldi_abdibaitov_mo5_hw_3.databinding.ItemImageBinding

class ImageAdapter(private val list: ArrayList<ImageModel>) :
    Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(private val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(image: ImageModel) {
            binding.pixabayImage.load(image.largeImageURL)
        }
    }

    fun addNewImages(list: ArrayList<ImageModel>) {
        this.list.addAll(list)
        notifyItemChanged(0)
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}