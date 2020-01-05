package com.servshare.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.servshare.R
import com.servshare.data.models.models.Service
import com.servshare.ui.interfaces.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.item_service.view.*
import java.text.SimpleDateFormat
import java.util.*

class ServiceAdapter(val items : ArrayList<Service>, val context: Context, val itemClickListener: RecyclerViewItemClickListener) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_service, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.serviceName?.text = items[position].name
        holder.servicePrice?.text = context.getString(R.string.sample_service_price, items[position].price)
        holder.serviceLocation?.text = items[position].location

        val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        holder.serviceDate?.text = sdf.format(items[position].date)

        holder.itemView?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                v?.let { itemClickListener.onClickItem(it, position) }
            }
        })
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val serviceContainer = view.serviceContainer
    val serviceName = view.name
    val servicePrice = view.price
    val serviceDate = view.date
    val serviceLocation = view.location
}