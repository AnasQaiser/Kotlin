package com.servshare.ui.view.home

import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProviders
import com.servshare.R
import com.servshare.ui.view.BaseFragment

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        setTitle("Dashboard")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.main, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            R.id.menu_add_service -> {
                sendInteractionToActivity(HomeFragment::class.java.simpleName, 1, null)
            }

            R.id.menu_profile -> {
                sendInteractionToActivity(HomeFragment::class.java.simpleName, 2, null)
            }

            R.id.menu_sign_out -> {
                sendInteractionToActivity(HomeFragment::class.java.simpleName, 3, null)
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return true;
    }

}
