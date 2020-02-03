package np.com.nawarajbista.weatherlearningmvvm.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import np.com.nawarajbista.weatherlearningmvvm.network.BASE_URL
import np.com.nawarajbista.weatherlearningmvvm.network.WeatherNetwork
import np.com.nawarajbista.weatherlearningmvvm.network.model.weatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivityRepository(val application: Application) {
    val showProgress = MutableLiveData<Boolean>()
    val response = MutableLiveData<weatherResponse>()

    fun getWeather(woeid: Int) {
        showProgress.value = true

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(WeatherNetwork::class.java)

        service.getWeather(woeid).enqueue(object: Callback<weatherResponse>{
            override fun onFailure(call: Call<weatherResponse>, t: Throwable) {
                showProgress.value = false
                Toast.makeText(application, "error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<weatherResponse>,
                resp: Response<weatherResponse>
            ) {

                response.value = resp.body()
                showProgress.value = false
            }

        })
    }
}