package com.example.meli.core.repository

import com.example.meli.core.vo.GetSearchVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MeLiService {

    @GET("search")
    fun search(@Query("q") query: String): Call<GetSearchVO>
}
