package com.hyunjung.todoapp.list

import androidx.navigation.fragment.findNavController
import com.hyunjung.todoapp.R
import com.hyunjung.todoapp.core.BaseFragment
import com.hyunjung.todoapp.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    override fun initView() {
        binding.fabListAdd.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_add)
        }
    }
}