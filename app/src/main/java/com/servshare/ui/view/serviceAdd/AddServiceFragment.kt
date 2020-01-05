package com.servshare.ui.view.serviceAdd

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.servshare.R
import com.servshare.ui.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_service.*
import java.text.SimpleDateFormat
import java.util.*


class AddServiceFragment : BaseFragment() {

    val myCalendar: Calendar = Calendar.getInstance()

    lateinit var dateSetListener: OnDateSetListener;

    companion object {
        fun newInstance() = AddServiceFragment()
    }

    private lateinit var serviceViewModel: AddServiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_service, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        serviceViewModel = ViewModelProviders.of(this).get(AddServiceViewModel::class.java)

        setTitle("Add Service")

        dateSetListener =
            OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, monthOfYear)
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateLabel()
            }

        date.editText?.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                DatePickerDialog(
                    this@AddServiceFragment.requireContext(), dateSetListener, myCalendar[Calendar.YEAR], myCalendar[Calendar.MONTH],
                    myCalendar[Calendar.DAY_OF_MONTH]
                ).show()
            }
        })
    }

    fun updateLabel() {
        val myFormat = "MM/dd/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        date.editText?.setText(sdf.format(myCalendar.time))
    }

}
