package com.example.androidretrofitheader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.androidretrofitheader.Model.Country
import com.example.androidretrofitheader.Model.State
import com.example.androidretrofitheader.databinding.ActivityMainBinding
import com.example.androidretrofitheader.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        loadCountry()



    }

    private fun loadCountry() {
      ApiClient.init().getCountry(ApiClient.getHeaderMap()).enqueue(object:Callback<List<Country>>{
          override fun onResponse(
              call: Call<List<Country>>,
              response: Response<List<Country>>
          ) {
              //success
              if (response.isSuccessful) {
                  var res = response.body()

                  res?.let {
                      var adapter = ArrayAdapter(
                          applicationContext,
                          android.R.layout.simple_spinner_dropdown_item,
                          it
                      )

                      binding.autoCountry.setAdapter(adapter)

                      binding.autoCountry.setOnItemClickListener { adapterView, view, pi, id ->

                          var country = it[pi].name
                          loadState(country)
                      }
                  }
              }
          }

          override fun onFailure(call: Call<List<Country>>, t: Throwable) {
             //fail

              Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
          }


      })
    }

    private fun loadState(country: String) {

        ApiClient.init().getState(ApiClient.getHeaderMap(),country).enqueue(object : Callback<List<State>>{
            override fun onResponse(call: Call<List<State>>, response: Response<List<State>>) {
                if (response.isSuccessful) {
                    var res = response.body()

                    res?.let {
                        var adapter=ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,it)

                        binding.autoState.setAdapter(adapter)

                        binding.autoState.setOnItemClickListener { adapterView, view, pi, id ->

                            var state=it[pi].name

                    }
                }
            }
            }

            override fun onFailure(call: Call<List<State>>, t: Throwable) {
                Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
            }

        })
    }
}