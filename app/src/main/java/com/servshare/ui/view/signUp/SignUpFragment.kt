package com.servshare.ui.view.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.servshare.R
import com.servshare.ui.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : BaseFragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)

        setTitle("Sign Up")

        btnSignUp.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View): Unit {

                sendInteractionToActivity(SignUpFragment::class.java.simpleName, 1, null)
            }
        })
    }
}
