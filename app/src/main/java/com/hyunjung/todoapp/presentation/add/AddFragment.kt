package com.hyunjung.todoapp.presentation.add

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.hyunjung.todoapp.R
import com.hyunjung.todoapp.data.models.ToDoData
import com.hyunjung.todoapp.data.viewmodel.ToDoViewModel
import com.hyunjung.todoapp.databinding.FragmentAddBinding
import com.hyunjung.todoapp.presentation.SharedViewModel
import com.hyunjung.todoapp.presentation.core.BaseFragment

class AddFragment : BaseFragment<FragmentAddBinding>(FragmentAddBinding::inflate) {

    private val toDoViewModel: ToDoViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun initView() {
        setMenu()
        binding.spinnerPriorities.onItemSelectedListener = sharedViewModel.listener
    }

    private fun setMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_fragment_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == android.R.id.home) requireActivity().onBackPressedDispatcher.onBackPressed()
                if (menuItem.itemId == R.id.menu_add) insertData()
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun insertData() {
        val mTitle = binding.etAddTitle.text.toString()
        val mPriority = binding.spinnerPriorities.selectedItem.toString()
        val mDescription = binding.etAddDescription.text.toString()

        val validation = sharedViewModel.verifyDataFromUser(mTitle, mDescription)

        if (validation) {
            val newData = ToDoData(
                id = 0,
                title = mTitle,
                priority = sharedViewModel.parsePriority(mPriority),
                description = mDescription
            )
            toDoViewModel.insertData(newData)
            Toast.makeText(requireContext(), "Successfully added.", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_add_to_list)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }
}