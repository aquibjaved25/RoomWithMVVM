package com.roomdbself.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.roomdbself.room.dao.DeviceDao
import com.roomdbself.model.DeviceListInventoryModel

class DeviceRepository (private val dao: DeviceDao)
{
    val allDevices: LiveData<List<DeviceListInventoryModel>> = dao.getDevice()




    suspend fun insert(word: DeviceListInventoryModel) {
        dao.insert(word)
    }

    suspend fun delete(deleteWord : String)
    {
        dao.deleteDevice(deleteWord)
    }

    suspend fun updateInventory(available_inventory:Int ,device_name : String)
    {
        dao.updateInventory(device_name,available_inventory)
    }

    suspend fun lostDeviceInventory(available_inventory:Int ,device_name : String)
    {
        dao.updateTotalInventory(device_name,available_inventory)
    }

    suspend fun deleteAll()
    {
        dao.deleteAll()
    }

}