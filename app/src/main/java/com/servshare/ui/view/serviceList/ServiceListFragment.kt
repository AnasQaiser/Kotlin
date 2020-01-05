package com.servshare.ui.view.serviceList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.servshare.R
import com.servshare.data.models.models.Service
import com.servshare.ui.adapter.ServiceAdapter
import com.servshare.ui.interfaces.RecyclerViewItemClickListener
import com.servshare.ui.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_service_list.*

class ServiceListFragment : BaseFragment(), RecyclerViewItemClickListener {

    var services = arrayListOf<Service>()
    var itemClickListener : RecyclerViewItemClickListener = this;

    companion object {
        fun newInstance(bundle: Bundle?) : ServiceListFragment {

            val fragment = ServiceListFragment()
            val args = Bundle()
            args.putParcelable("data", bundle)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var viewModel: ServiceListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ServiceListViewModel::class.java)

        setTitle("All Services")

        servicesRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        services = arguments!!.get("data") as ArrayList<Service>

        servicesRecyclerView.adapter = context?.let {
            ServiceAdapter(services,
                it, itemClickListener)
        }
    }

    override fun onClickItem(view: View, position: Int) {

        if (services.size >= position){

            val bundle = Bundle()
            bundle.putParcelable("data", services[position])

            sendInteractionToActivity(ServiceListFragment::class.java.simpleName, 1, bundle)
        }
    }
}
