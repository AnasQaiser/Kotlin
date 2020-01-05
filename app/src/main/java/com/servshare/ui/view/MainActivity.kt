package com.servshare.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.servshare.R
import com.servshare.ui.interfaces.FragmentInteractionListener
import com.servshare.ui.view.home.HomeFragment
import com.servshare.ui.view.login.LoginFragment
import com.servshare.ui.view.profile.ProfileFragment
import com.servshare.ui.view.serviceAdd.AddServiceFragment
import com.servshare.ui.view.serviceList.ServiceListFragment
import com.servshare.ui.view.serviceView.ViewServiceFragment
import com.servshare.ui.view.signUp.SignUpFragment

class MainActivity : AppCompatActivity(),
    FragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment("Login", null)
    }

    private fun setFragment(fragmentTag: String, bundle: Bundle?) {
        var fragment: Fragment? = null

        when (fragmentTag) {
            "Login" -> {
                fragment = LoginFragment()
            }
            "Sign Up" -> {
                fragment = SignUpFragment()
            }

            "Home" -> {
                fragment = HomeFragment();
            }

            "Service List" -> {
                fragment = ServiceListFragment.newInstance(bundle)
            }

            "Add Service" -> {
                fragment = AddServiceFragment();
            }

            "Profile" -> {
                fragment = ProfileFragment();
            }

            "Service View" -> {
                fragment = ViewServiceFragment.newInstance(bundle)
            }
        }

        if (fragment != null) {

            if (!fragment.isVisible) {

                if (bundle != null)
                    fragment.arguments = bundle

                val transaction = supportFragmentManager.beginTransaction()
                transaction.setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
                transaction.replace(R.id.fragment_container, fragment)
                transaction.addToBackStack(fragmentTag)
                transaction.commit()
            }
        }
    }

    override fun onFragmentInteraction(sourceFragment: String, action: Int, data: Any?) {

        when (sourceFragment) {

            "LoginFragment" -> {

                when (action) {

                    2 -> {
                        setFragment("Sign Up", null)
                    }

                    1 -> {
                        setFragment("Home", null)
                    }
                }
            }
            "SignUpFragment" -> {

                when (action) {

                    1 -> {
                        setFragment("Login", null)
                    }
                }
            }
            "HomeFragment" -> {

                when (action){
                    1 -> {
                        setFragment("Add Service", null)
                    }
                    2 -> {
                        setFragment("Profile", null)
                    }
                    3 -> {
                        setFragment("Login", null)
                    }
                }
            }
            "ProfileFragment" -> {

               when(action) {

                   1 -> {
                       setFragment("Service List", data as Bundle?)
                   }
                   2 -> {
                       setFragment("Service List", data as Bundle?)
                   }
               }
            }
            "ServiceListFragment" -> {

                when(action){

                    1 -> {
                        setFragment("Service View", data as Bundle)
                    }
                }
            }
        }
    }
}
