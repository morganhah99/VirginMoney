package com.example.virginmoney.ui.list.people

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.virginmoney.databinding.FragmentPersonDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PersonDetailFragment : Fragment() {

    lateinit var binding: FragmentPersonDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonDetailBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        // arguments -> default functionality to hanlde any bundles passed from previous fragments
        val firstName = arguments?.getString("firstName")
        val lastName = arguments?.getString("lastName")
        val color = arguments?.getString("color")?.replaceFirstChar { it.uppercase() }
        val job = arguments?.getString("job")
        val image = arguments?.getString("image")
        val email = arguments?.getString("email")

        binding.apply {
            Glide.with(requireContext()).load(image).into(ivProfile)
            tvFirstName.text = firstName
            tvFavoriteColor.text = color
            tvJobTitle.text = job
            tvLastName.text = lastName
            tvEmail.text = email

        }

        return binding.root
    }

    @SuppressLint("PrivateResource")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolBar = binding.toolbar
        toolBar.setNavigationIcon(com.google.android.material.R.drawable.ic_arrow_back_black_24)
        toolBar.setNavigationOnClickListener{
            findNavController().navigateUp()
        }
    }


}