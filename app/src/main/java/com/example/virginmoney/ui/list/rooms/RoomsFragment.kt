package com.example.virginmoney.ui.list.rooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPeopleBinding
import com.example.virginmoney.databinding.FragmentRoomsBinding
import com.example.virginmoney.ui.list.people.PeopleAdapter
import org.w3c.dom.Text


class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val roomViewModel =
//            ViewModelProvider(this).get(RoomsViewModel::class.java)
//
//        _binding = FragmentRoomsBinding.inflate(inflater,container, false)
//        val root: View = binding.root
//        binding.apply {
//            roomViewModel.roomList.observe(viewLifecycleOwner) {
//                rvRooms.apply {
//                    layoutManager = LinearLayoutManager(context)
//                    adapter = RoomsAdapter(it)
//                }
//            }
//        }
//        return root

        val roomViewModel =
            ViewModelProvider(this).get(RoomsViewModel::class.java)
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rvRooms.layoutManager = LinearLayoutManager(context)
        binding.rvRooms.adapter = RoomsAdapter(emptyList())
        binding.apply {
            roomViewModel.roomList.observe(viewLifecycleOwner) {
                rvRooms.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = RoomsAdapter(it)
                }
            }
        }


        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}