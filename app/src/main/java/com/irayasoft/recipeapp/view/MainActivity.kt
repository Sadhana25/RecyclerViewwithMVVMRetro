package com.irayasoft.recipeapp.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.irayasoft.recipeapp.R
import com.irayasoft.recipeapp.model.ResponseDataItem
import com.irayasoft.recipeapp.network.ApiService
import com.irayasoft.recipeapp.network.RetrofitClient
import com.irayasoft.recipeapp.repository.Repository
import com.irayasoft.recipeapp.viewmodel.ActivityViewModel
import com.irayasoft.recipeapp.viewmodel.ActivityViewModelfactory
class MainActivity : AppCompatActivity() {
    private val TAG:String=MainActivity::class.java.name
    lateinit var activityViewModel: ActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        setContentView(R.layout.activity_main)
        val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
        val repository = Repository(apiService)

        activityViewModel = ViewModelProvider(
            this,
            ActivityViewModelfactory(repository)
        ).get(ActivityViewModel::class.java)

       activityViewModel.data.observe(this, Observer {
           it.size
           Log.d(TAG, "onCreate: "+it.toString())

          val receiveData:List<ResponseDataItem> =it
          val item: ResponseDataItem=it.get(2)
           Log.d(TAG, "onCreate: "+item.id+item.title)
       })
    }
}