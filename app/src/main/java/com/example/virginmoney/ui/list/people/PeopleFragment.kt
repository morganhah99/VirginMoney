package com.example.virginmoney.ui.list.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.virginmoney.databinding.FragmentPeopleBinding


class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val peopleViewmodel =
            ViewModelProvider(this).get(PeopleViewModel::class.java)
        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.test
        peopleViewmodel.peopleList.observe(viewLifecycleOwner) {
            textView.text = it.toString()
        }

        return root
    }


}