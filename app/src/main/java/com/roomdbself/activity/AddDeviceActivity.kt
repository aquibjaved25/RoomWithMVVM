package com.roomdbself.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.roomdbself.R
import com.roomdbself.model.DeviceListInventoryModel
import com.roomdbself.viewModel.DeviceViewModel
import kotlinx.android.synthetic.main.activity_add_device.*

class AddDeviceActivity : AppCompatActivity() {

    private lateinit var deviceViewModel : DeviceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_device)

        setTitleAndBackButton()
        deviceViewModel = ViewModelProvider(this).get(DeviceViewModel::class.java)

        tv_add_employee.setOnClickListener {
            if (validation()) {
                deviceViewModel.insert(DeviceListInventoryModel(et_device_name.text.toString(), et_total_inventory.text.toString().toInt(), et_total_inventory.text.toString().toInt()))
                finish()
            }
        }
    }

    private fun validation():Boolean{

        if (et_device_name.text.toString().trim().isEmpty() ||
            et_device_name.text.toString().trim().isBlank()) {

            Toast.makeText(this,"Please enter a valid name", Toast.LENGTH_LONG).show()
            return false
        }
        if (et_total_inventory.text.toString().trim().isEmpty() ||
            et_total_inventory.text.toString().trim().isBlank()) {
            Toast.makeText(this,"Please enter a valid inventory size", Toast.LENGTH_LONG).show()
            return false
        }
        return  true
    }

    private fun setTitleAndBackButton(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add Device"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}