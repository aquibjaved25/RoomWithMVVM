package com.roomdbself.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.roomdbself.model.DeviceListInventoryModel

@Dao
interface DeviceDao {

    @Query("Select * from device ")
    fun getDevice():  LiveData<List<DeviceListInventoryModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(addDevice: DeviceListInventoryModel )

    @Query("DELETE FROM device WHERE device_name = :deleteWord")
    suspend fun deleteDevice(deleteWord : String)

    @Query("UPDATE device SET available_inventory = :available_inventory WHERE device_name = :device_name")
    suspend fun updateInventory(device_name: String, available_inventory: Int)

    @Query("UPDATE device SET total_inventory = :total_inventory WHERE device_name = :device_name")
    suspend fun updateTotalInventory(device_name: String, total_inventory: Int)


    @Query("DELETE FROM device")
    suspend fun deleteAll()
}