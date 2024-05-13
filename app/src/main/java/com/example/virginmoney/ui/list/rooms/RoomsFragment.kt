package com.example.virginmoney.ui.list.rooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.databinding.FragmentRoomsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    private val roomViewModel: RoomsViewModel by viewModels()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvRooms.layoutManager = LinearLayoutManager(context)
        val roomsAdapter = RoomsAdapter(emptyList())
        binding.rvRooms.adapter = roomsAdapter

        lifecycleScope.launchWhenCreated {
            roomViewModel.roomList.collect { roomsItemModelList ->
                roomsAdapter.roomList = roomsItemModelList
                roomsAdapter.notifyDataSetChanged()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}