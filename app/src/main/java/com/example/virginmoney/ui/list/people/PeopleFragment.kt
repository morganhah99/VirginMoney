package com.example.virginmoney.ui.list.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    private val peopleViewmodel: PeopleViewModel by viewModels()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            lifecycleScope.launchWhenCreated {
                peopleViewmodel.peopleList.collect {
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
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}