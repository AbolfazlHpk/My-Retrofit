package com.example.myapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.data.Model.PostItem
import com.example.myapp.databinding.ItemCardBinding

class ItemCardViewHolder(private val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindViews(model: PostItem){
        binding.apply {
            title.text=model.title
            body.text=model.body
            userId.text=model.userId.toString()
        }
    }
}