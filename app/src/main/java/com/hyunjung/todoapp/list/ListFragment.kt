package com.hyunjung.todoapp.list

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController
import com.hyunjung.todoapp.R
import com.hyunjung.todoapp.core.BaseFragment
import com.hyunjung.todoapp.databinding.FragmentListBinding

class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    override fun initView() {
        with(binding) {
            fabListAdd.setOnClickListener {
                findNavController().navigate(R.id.action_list_to_add)
            }
            fragmentList.setOnClickListener {
                findNavController().navigate(R.id.action_list_to_update)
            }
        }
        setMenu()
    }

    private fun setMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.list_fragment_menu, menu)

                val search = menu.findItem(R.id.menu_search)
                val searchView = search.actionView as SearchView
                searchView.isSubmitButtonEnabled = true
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        })
    }
}