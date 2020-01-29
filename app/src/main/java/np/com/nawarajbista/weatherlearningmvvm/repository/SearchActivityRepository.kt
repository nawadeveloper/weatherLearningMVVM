package np.com.nawarajbista.weatherlearningmvvm.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import np.com.nawarajbista.weatherlearningmvvm.network.BASE_URL
import np.com.nawarajbista.weatherlearningmvvm.network.WeatherNetwork
import np.com.nawarajbista.weatherlearningmvvm.network.model.Location
import np.com.nawarajbista.weatherlearningmvvm.network.model.weatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()

    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun searchLocation(searchString: String) {

        showProgress.value = true

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val service = retrofit.create(WeatherNetwork::class.java)

        service.getWeather("2295424").enqueue(object : Callback<weatherResponse>{
            override fun onFailure(call: Call<weatherResponse>, t: Throwable) {

                showProgress.value = false
                Toast.makeText(application, "Error occur on receiving data", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<weatherResponse>,
                response: Response<weatherResponse>
            ) {

                Log.d("SearchActivity", "Response: ${Gson().toJson(response.body())}")
                showProgress.value = false
            }

        })
    }
}