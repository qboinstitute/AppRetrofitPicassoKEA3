package com.qbo.appretrofitpicassokea3.api

import com.qbo.appretrofitpicassokea3.model.Foto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiFotoService {

    @GET("photos")
    fun obtenerTodasLasFotos(): Call<List<Foto>>



}