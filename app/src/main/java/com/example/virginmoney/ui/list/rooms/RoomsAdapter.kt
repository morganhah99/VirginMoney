package com.example.virginmoney.ui.list.rooms

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.virginmoney.R
import com.example.virginmoney.data.model.rooms.RoomsItemModel
import com.example.virginmoney.databinding.ItemRoomBinding

class RoomsAdapter(
    var roomList: List<RoomsItemModel>
) : RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder>() {

    inner class RoomsViewHolder(itemView: View) : ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun updateUI(roomsItemModel: RoomsItemModel) {
            binding.apply {
                tvRoomNumber.text = "Room Number: ${roomsItemModel.id}"
                if (roomsItemModel.isOccupied.toString() == "true") {
                    tvOccupancy.text = "Occupied"
                } else {
                    tvOccupancy.text = "Vacant"
                }
            }
        }
        val binding = ItemRoomBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        return RoomsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        )
    }

    override fun getItemCount() = roomList.size

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        holder.updateUI(roomList[position])
    }
}