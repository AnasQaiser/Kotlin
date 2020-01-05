package com.servshare.ui.view.serviceView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.servshare.R
import com.servshare.data.models.models.Service
import com.servshare.ui.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_view_service.*
import java.text.SimpleDateFormat
import java.util.*


class ViewServiceFragment : BaseFragment() {

    companion object {
        fun newInstance(bundle: Bundle?) : ViewServiceFragment {

            val fragment = ViewServiceFragment()
            val args = Bundle()
            args.putParcelable("data", bundle)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var viewModel: ViewServiceModel

    lateinit var service : Service

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_service, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewServiceModel::class.java)

        service = arguments!!.get("data") as Service

        setTitle(service.name)
        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)

        serviceName.text = service.name
        servicePrice.text = getString(R.string.sample_service_price, service.price)
        serviceDate.text = sdf.format(service.date)
        serviceLocation.text = service.location
        serviceDescription.text = service.description
    }

}
