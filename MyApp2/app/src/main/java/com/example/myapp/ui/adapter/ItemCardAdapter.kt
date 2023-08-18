package com.example.myapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.data.Model.PostItem
import com.example.myapp.databinding.ItemCardBinding

class ItemCardAdapter: RecyclerView.Adapter<ItemCardViewHolder>() {
    private var postList= emptyList<PostItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardViewHolder =
       ItemCardViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ItemCardViewHolder, position: Int) {
        holder.bindViews(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    @SuppressLint("NotifySetDataChanged")
    fun setData(newList: List<PostItem>){
postList=newList
        notifyDataSetChanged()
    }
}