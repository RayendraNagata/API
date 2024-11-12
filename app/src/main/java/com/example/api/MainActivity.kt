package com.example.api

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.Adapter.ProvinceAdapter
import com.example.api.Model.Authors
import com.example.api.Model.Province
import com.example.api.Network.ApiClient
import com.example.api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val client = ApiClient.getInstance()
        val responseProvinces = client.getProvinces()

        responseProvinces.enqueue(object : Callback<List<Province>> {
            override fun onResponse(call: Call<List<Province>>, response: Response<List<Province>>) {
                if (response.isSuccessful) {
                    response.body()?.let { provinces ->
                        binding.recyclerView.adapter = ProvinceAdapter(provinces)
                    }
                }
            }

            override fun onFailure(call: Call<List<Province>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

