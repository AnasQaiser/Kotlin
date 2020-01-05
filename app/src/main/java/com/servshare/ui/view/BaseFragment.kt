package com.servshare.ui.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.servshare.ui.interfaces.FragmentInteractionListener

open class BaseFragment : Fragment() {

    private var listener: FragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement FragmentInteractionListener")
        }
    }

    fun sendInteractionToActivity(sourceFragment: String, action: Int, data: Any?){
        listener?.onFragmentInteraction(sourceFragment, action, data)
    }

    fun setTitle(title : String){
        (activity as AppCompatActivity).supportActionBar?.setTitle(title)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
