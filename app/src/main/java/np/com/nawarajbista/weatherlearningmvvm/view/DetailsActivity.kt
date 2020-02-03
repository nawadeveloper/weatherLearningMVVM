package np.com.nawarajbista.weatherlearningmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_detail.*
import np.com.nawarajbista.weatherlearningmvvm.R
import np.com.nawarajbista.weatherlearningmvvm.viewModel.DetailActivityViewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        viewModel = ViewModelProvider(this).get(DetailActivityViewModel::class.java)

        if(intent.hasExtra("name")) {
            tv_location.text = intent.getStringExtra("name")
        }

        if(intent.hasExtra("Location")) {
            val location = intent.getIntExtra("Location", 0)
            if(location > 0) {
                viewModel.getWeather(location)
            }
        }

        viewModel.showProgress.observe(this, Observer {
            if(it) {
                details_progress.visibility = VISIBLE
            }
            else {
                details_progress.visibility = GONE
            }
        })

        viewModel.response.observe(this, Observer {
            if(it != null)
                tv_temp.text = it.consolidated_weather[0].the_temp.toString()
        })
    }
}
