package com.example.virginmoney.ui.list.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPersonDetailBinding


class PersonDetailFragment : Fragment() {

    lateinit var binding: FragmentPersonDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        // arguments -> default functionality to hanlde any bundles passed from previous fragments
        val firstName = arguments?.getString("firstName")
        val color = arguments?.getString("color")
        val job = arguments?.getString("job")
        val image = arguments?.getString("image")

        binding.apply {
            Glide.with(requireContext()).load(image).into(ivProfile)
            tvFirstName.text = firstName
            tvFavoriteColor.text = color
            tvJobTitle.text = job
        }

        return binding.root
    }


}