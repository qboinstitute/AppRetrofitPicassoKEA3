package com.qbo.appretrofitpicassokea3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.qbo.appretrofitpicassokea3.R
import com.qbo.appretrofitpicassokea3.adapter.FotoAdapter
import com.qbo.appretrofitpicassokea3.api.ApiFotoService
import com.qbo.appretrofitpicassokea3.databinding.ActivityMainBinding
import com.qbo.appretrofitpicassokea3.model.Foto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiservice: ApiFotoService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val vista = binding.root
        setContentView(vista)
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        //binding.rvfotos.layoutManager = LinearLayoutManager(this)
        //binding.rvfotos.layoutManager = GridLayoutManager(this, 3)
        binding.rvfotos.layoutManager = StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL)
        apiservice = retrofit.create<ApiFotoService>(ApiFotoService::class.java)
        obtenerFotos()
    }

    private fun obtenerFotos() {
        apiservice.obtenerTodasLasFotos().enqueue(object : Callback<List<Foto>>{
            override fun onResponse(call: Call<List<Foto>>, response: Response<List<Foto>>) {
                if(!response.body().isNullOrEmpty()){
                    val listafoto = response.body()!!
                    binding.rvfotos.apply {
                        adapter = FotoAdapter(listafoto)
                    }
                }
            }
            override fun onFailure(call: Call<List<Foto>>, t: Throwable) {
                Log.e("ErrorAPI", t.message)
            }
        })
    }
}