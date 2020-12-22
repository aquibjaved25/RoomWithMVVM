package com.roomdbself.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.roomdbself.model.DeviceListInventoryModel
import com.roomdbself.room.dao.DeviceDao

@Database(entities = [DeviceListInventoryModel::class ], version = 1, exportSchema = false)
public abstract class DeviceDatabase  : RoomDatabase(){

    abstract fun DeviceDao(): DeviceDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DeviceDatabase? = null

        fun getDeviceDatabase(context: Context): DeviceDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DeviceDatabase::class.java,
                    "device_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}