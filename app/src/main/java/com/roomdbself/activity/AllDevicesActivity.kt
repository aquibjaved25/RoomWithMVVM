package com.roomdbself.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roomdbself.R
import com.roomdbself.adapter.AllDeviceAdapter
import com.roomdbself.model.DeviceListInventoryModel
import com.roomdbself.viewModel.DeviceViewModel
import kotlinx.android.synthetic.main.activity_all_devices.*

class AllDevicesActivity : AppCompatActivity() {

    private lateinit var layoutManager: RecyclerView.LayoutManager
    var deviceListdataList = ArrayList<DeviceListInventoryModel>()

    private lateinit var deviceViewModel : DeviceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_devices)

        setTitleAndBackButton()

        layoutManager = LinearLayoutManager(this)
        rv_all_employee_ist.layoutManager = layoutManager

        rv_all_employee_ist.adapter = AllDeviceAdapter(this, deviceListdataList)

        //  getValues()

        deviceViewModel = ViewModelProvider(this).get(DeviceViewModel::class.java)

        deviceViewModel.allDevices.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let {
                // adapter.setWords(it)


                rv_all_employee_ist.visibility = View.GONE

                deviceListdataList.clear()
                deviceListdataList.addAll(it)
                rv_all_employee_ist.adapter?.notifyDataSetChanged()


                rv_all_employee_ist.visibility = View.VISIBLE
            }
        })



    }

    private fun setTitleAndBackButton(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "All Devices"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}