package com.roomdbself.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.roomdbself.R
import com.roomdbself.activity.AllDevicesActivity
import com.roomdbself.model.DeviceListInventoryModel
import kotlinx.android.synthetic.main.item_all_device.view.*


class AllDeviceAdapter(
    private val context: AllDevicesActivity,
    private val devicesListModel: ArrayList<DeviceListInventoryModel>
) :
    RecyclerView.Adapter<AllDeviceAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_all_device,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return devicesListModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.deviceName.text = devicesListModel[position].deviceName
        holder.totalInventory.text = devicesListModel[position].totalInventory.toString()
        holder.availableInventory.text = devicesListModel[position].availableInventory.toString()

        holder.itemView.setOnClickListener {
           Toast.makeText(context, devicesListModel[position].deviceName, Toast.LENGTH_SHORT).show()
           // getAlertDailog(position)
        }



    }

//    fun getAlertDailog( position: Int){
//        val builder = AlertDialog.Builder(context)
//        builder.setTitle("Update/Delete")
//        builder.setMessage("you can either delete or update")
////builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))
//
//        builder.setPositiveButton("Update") { dialog, which ->
//            Toast.makeText(context,
//                android.R.string.yes, Toast.LENGTH_SHORT).show()
//        }
//
//        builder.setNegativeButton(android.R.string.no) { dialog, which ->
//            Toast.makeText(context,
//                android.R.string.no, Toast.LENGTH_SHORT).show()
//        }
//
//        builder.setNeutralButton("Delete") { dialog, which ->
//            onDelete(position)
//        }
//        builder.show()
//    }
//
//
//    private fun onDelete(position: Int){
//        Toast.makeText(context,
//            "Delete"+(position+1), Toast.LENGTH_SHORT).show()
//    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deviceName: TextView = view.text_device_name
        val totalInventory: TextView = view.text_total_inventory
        val availableInventory: TextView = view.text_available_inventory

    }


}