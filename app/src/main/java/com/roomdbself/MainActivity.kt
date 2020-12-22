package com.roomdbself

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.roomdbself.activity.AddDeviceActivity
import com.roomdbself.activity.AllDevicesActivity
import kotlinx.android.synthetic.main.activity_add_device.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_add_new_device.setOnClickListener{

            val intent = Intent(this, AddDeviceActivity::class.java)
            startActivity(intent)
        }



        tv_all_devices.setOnClickListener{

            val intent = Intent(this, AllDevicesActivity::class.java)
            startActivity(intent)
        }


    }


}