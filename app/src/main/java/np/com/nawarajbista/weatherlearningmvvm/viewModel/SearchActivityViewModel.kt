package np.com.nawarajbista.weatherlearningmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import np.com.nawarajbista.weatherlearningmvvm.repository.SearchActivityRepository

class SearchActivityViewModel(application: Application): AndroidViewModel(application) {

    val repository = SearchActivityRepository(application)
    val showProgress: LiveData<Boolean>

    init {
        this.showProgress = repository.showProgress
    }

    fun changeState() {
        repository.changeState()
    }
}