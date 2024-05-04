package com.example.virginmoney.ui.list.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.People
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.databinding.ItemPersonBinding

class PeopleAdapter(
    val peopleList: List<PeopleItemModel>,
    val function: (PeopleItemModel) -> Unit
) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){

    inner class PeopleViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = ItemPersonBinding.bind(itemView)
        fun updateUI(peopleItemModel: PeopleItemModel) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(peopleItemModel.avatar)
                    .placeholder(R.drawable.person_logo)
                    .into(ivProfile)
                tvFirstName.text = peopleItemModel.firstName
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        )
    }

    override fun getItemCount() = peopleList.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.updateUI(peopleList[position])

        holder.binding.root.setOnClickListener {
            function.invoke(peopleList[position])
        }
    }
}