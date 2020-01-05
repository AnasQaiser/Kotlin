package com.servshare.ui.view.login

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.servshare.R
import com.servshare.ui.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // create ContextThemeWrapper from the original Activity Context with the custom theme
        val contextThemeWrapper: Context =
            ContextThemeWrapper(activity, R.style.MaterialTheme)

        // clone the inflater using the ContextThemeWrapper
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        return localInflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        setTitle("Login")

        btnLogin.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                sendInteractionToActivity(LoginFragment::class.java.simpleName, 1, null)
            }
        })

        tvSignup.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {

                sendInteractionToActivity(LoginFragment::class.java.simpleName, 2, null)
            }
        })
    }

}
