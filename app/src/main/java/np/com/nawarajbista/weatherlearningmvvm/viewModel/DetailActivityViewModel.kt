package np.com.nawarajbista.weatherlearningmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import np.com.nawarajbista.weatherlearningmvvm.network.model.weatherResponse
import np.com.nawarajbista.weatherlearningmvvm.repository.DetailActivityRepository

class DetailActivityViewModel(application: Application):AndroidViewModel(application) {

    private val repository = DetailActivityRepository(application)

    val showProgress: LiveData<Boolean>
    val response: LiveData<weatherResponse>

    init {
        showProgress = repository.showProgress
        response = repository.response
    }

    fun getWeather(woeid: Int) {
        repository.getWeather(woeid)
    }
}