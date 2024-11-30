package com.hyunjung.todoapp.update

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.hyunjung.todoapp.R
import com.hyunjung.todoapp.core.BaseFragment
import com.hyunjung.todoapp.databinding.FragmentUpdateBinding

class UpdateFragment : BaseFragment<FragmentUpdateBinding>(FragmentUpdateBinding::inflate) {

    override fun initView() {
        setMenu()
    }

    private fun setMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.update_fragment_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == android.R.id.home) requireActivity().onBackPressedDispatcher.onBackPressed()
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}