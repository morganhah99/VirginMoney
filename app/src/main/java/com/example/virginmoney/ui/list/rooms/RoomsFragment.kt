package com.example.virginmoney.ui.list.rooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPeopleBinding
import com.example.virginmoney.databinding.FragmentRoomsBinding


class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val roomViewModel =
            ViewModelProvider(this).get(RoomsViewModel::class.java)
        _binding = FragmentRoomsBinding.inflate(inflater,container, false)
        val root: View = binding.root

        val textView: TextView = binding.test

        roomViewModel.roomList.observe(viewLifecycleOwner) {
            textView.text = it.toString()
        }
        return root
    }


}