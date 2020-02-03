package np.com.nawarajbista.weatherlearningmvvm.network

import np.com.nawarajbista.weatherlearningmvvm.network.model.Location
import np.com.nawarajbista.weatherlearningmvvm.network.model.weatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://www.metaweather.com/api/location/"

interface WeatherNetwork {

    @GET("search?")
    fun getLocation(@Query("query")searchString: String) : Call<List<Location>>

    @GET("{woeid}")
    fun getWeather(@Path("woeid") woeid: Int): Call<weatherResponse>
}