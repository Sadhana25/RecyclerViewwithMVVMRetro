package com.irayasoft.recipeapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irayasoft.recipeapp.model.ResponseData
import com.irayasoft.recipeapp.model.ResponseDataItem
import com.irayasoft.recipeapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityViewModel(private val repository: Repository): ViewModel() {
    private val TAG:String=ActivityViewModel::class.java.name
    // mutable data
    // livedata

    init {
        Log.d(TAG, ": ")
        viewModelScope.launch (Dispatchers.IO)
        {
            Log.d(TAG, "coroutine call: ")
            repository.getData()
        }

    }
    val data:LiveData<ResponseData>
    get() = repository.dataR
}