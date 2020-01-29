package np.com.nawarajbista.weatherlearningmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import np.com.nawarajbista.weatherlearningmvvm.repository.DetailActivityRepository

class DetailActivityViewModel(application: Application):AndroidViewModel(application) {

    private val repository = DetailActivityRepository(application)
}