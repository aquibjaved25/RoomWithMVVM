package com.roomdbself.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device")
data class DeviceListInventoryModel(

    @PrimaryKey
    @ColumnInfo(name = "device_name")
    val deviceName: String,

    @ColumnInfo(name = "total_inventory")
    val totalInventory : Int,

    @ColumnInfo(name = "available_inventory")
    val availableInventory : Int
)