package com.example.virginmoney.ui.list.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        binding.apply {
            peopleViewmodel.peopleList.observe(viewLifecycleOwner) {

                rvPeople.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = PeopleAdapter(it) { peopleItemModel ->
                        findNavController().navigate(

                            R.id.action_peopleFragment_to_personDetailFragment,
                            bundleOf(
                                Pair("firstName", peopleItemModel.firstName),
                                Pair("image", peopleItemModel.avatar),
                                Pair("color", peopleItemModel.favouriteColor),
                                Pair("job", peopleItemModel.jobtitle),
                                Pair("lastName", peopleItemModel.lastName),
                                Pair("email", peopleItemModel.email)

                            )
                        )
                    }
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