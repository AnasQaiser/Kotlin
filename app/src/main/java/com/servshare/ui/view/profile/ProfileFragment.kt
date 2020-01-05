package com.servshare.ui.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.servshare.R
import com.servshare.data.models.models.Service
import com.servshare.ui.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

        setTitle("Your Profile")

        myServices.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {

                var bundle = Bundle()
                bundle.putParcelableArrayList("data", getServices())

                sendInteractionToActivity(ProfileFragment::class.java.simpleName, 1, bundle)
            }
        })

        servicesRequested.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {

                var bundle = Bundle()
                bundle.putParcelableArrayList("data", getServices())

                sendInteractionToActivity(ProfileFragment::class.java.simpleName, 2, bundle)
            }
        })
    }

    fun getServices(): ArrayList<Service> {

        var myServices = arrayListOf<Service>()
        myServices.add(Service("House Cleaning", 30.00,
            getString(R.string.sample_service_description),
            getString(R.string.sample_service_date),
            getString(R.string.sample_service_location)))

        myServices.add(Service("House Cleaning", 30.00,
            getString(R.string.sample_service_description),
            getString(R.string.sample_service_date),
            getString(R.string.sample_service_location)))

        myServices.add(Service("House Cleaning", 30.00,
            getString(R.string.sample_service_description),
            getString(R.string.sample_service_date),
            getString(R.string.sample_service_location)))

        myServices.add(Service("House Cleaning", 30.00,
            getString(R.string.sample_service_description),
            getString(R.string.sample_service_date),
            getString(R.string.sample_service_location)))

        return myServices
    }
}
