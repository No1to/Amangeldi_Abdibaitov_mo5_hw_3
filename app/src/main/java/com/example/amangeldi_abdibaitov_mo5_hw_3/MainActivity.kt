package com.example.amangeldi_abdibaitov_mo5_hw_3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.amangeldi_abdibaitov_mo5_hw_3.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var adapter = ImageAdapter(arrayListOf())
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
        binding.recyclerView.adapter = adapter
    }

    private fun initListener() {
        with(binding) {
            searchBtn.setOnClickListener {
                getImages(1)
            }
            nextBtn.setOnClickListener {
                page++
                getImages(page)
            }
        }
    }

    private fun ActivityMainBinding.getImages(page: Int) {
        RetrofitService().api.getImages(wordEt.text.toString(), page = page)
            .enqueue(object : Callback<PixabayModel> {
                override fun onResponse(
                    call: Call<PixabayModel>,
                    response: Response<PixabayModel>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            adapter.addNewImages(it.hits as ArrayList<ImageModel>)
                        }
                    }
                }

                override fun onFailure(call: Call<PixabayModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}