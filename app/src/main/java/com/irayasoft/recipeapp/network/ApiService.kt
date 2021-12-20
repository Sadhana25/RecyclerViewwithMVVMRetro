package com.irayasoft.recipeapp.network

import com.irayasoft.recipeapp.helpar.Constant
import com.irayasoft.recipeapp.model.ResponseData
import com.irayasoft.recipeapp.model.ResponseDataItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constant.END_POINT)
    suspend fun getResponseData():Response<ResponseData>
}