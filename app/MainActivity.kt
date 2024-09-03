package com.example.ipgeolocation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    private val ipGeolocationApiKey = "caa077ed9d7441fc93500edf3a623997"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ipTextView = findViewById<TextView>(R.id.ipTextView)
        val locationTextView = findViewById<TextView>(R.id.locationTextView)

        getCurrentIp { ip ->
            runOnUiThread {
                ipTextView.text = "IP: $ip"
            }

            getLocationInfo(ip) { locationInfo ->
                runOnUiThread {
                    locationTextView.text = locationInfo
                }
            }
        }
    }

    private fun getCurrentIp(callback: (String) -> Unit) {
        val request = Request.Builder()
            .url("https://api.ipify.org?format=json")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { responseBody ->
                    val jsonObject = JSONObject(responseBody)
                    val ip = jsonObject.getString("ip")
                    callback(ip)
                }
            }
        })
    }

    private fun getLocationInfo(ip: String, callback: (String) -> Unit) {
        val url = "https://api.ipgeolocation.io/ipgeo?apiKey=$ipGeolocationApiKey&ip=$ip"
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { responseBody ->
                    val jsonObject = JSONObject(responseBody)
                    val country = jsonObject.getString("country_name")
                    val city = jsonObject.getString("city")
                    val locationInfo = "City: $city, Country: $country"
                    callback(locationInfo)
                }
            }
        })
    }
}
