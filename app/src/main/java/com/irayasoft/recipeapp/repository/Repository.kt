package com.irayasoft.recipeapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.irayasoft.recipeapp.model.ResponseData
import com.irayasoft.recipeapp.model.ResponseDataItem
import com.irayasoft.recipeapp.network.ApiService


class Repository(private val apiService: ApiService) {
    private val TAG:String=Repository::class.java.name
    //mutable livedata
    private  val mutDataR=MutableLiveData<ResponseData>()
    //livedata public
    val dataR:LiveData<ResponseData>
    get() = mutDataR

    suspend fun getData(){
        Log.d(TAG, "getData:  initial call")
        val result=apiService.getResponseData()
        //null check and safe call

        if(result?.body() != null){
            // receive api data should be store in mutable livedata
            mutDataR.postValue(result.body())
            Log.d(TAG, "getData:  condition check"+result.toString())
            //mutable data hold the changing value
            // and store to live data which we can observe later

        }

    }
}