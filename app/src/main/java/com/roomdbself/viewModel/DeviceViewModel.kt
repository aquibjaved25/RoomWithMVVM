package com.roomdbself.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.roomdbself.model.DeviceListInventoryModel
import com.roomdbself.repository.DeviceRepository
import com.roomdbself.room.database.DeviceDatabase

import kotlinx.coroutines.launch

class DeviceViewModel(application: Application) : AndroidViewModel(application){

    private val repository: DeviceRepository
    // LiveData gives us updated words when they change.
    val allDevices: LiveData<List<DeviceListInventoryModel>>

    init {
        val dao = DeviceDatabase.getDeviceDatabase(application).DeviceDao()
        repository = DeviceRepository(dao)


        allDevices = repository.allDevices
    }

    fun getAllDevices(){
        viewModelScope.launch {
            repository.allDevices

        }
    }

    fun insert(word : DeviceListInventoryModel)
    {
        viewModelScope.launch {
            repository.insert(word)

        }
    }

    fun delete(){
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

    fun deleteWord(deleteWord : String){
        viewModelScope.launch {
            repository.delete(deleteWord)
        }
    }



}