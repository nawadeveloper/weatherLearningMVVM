package np.com.nawarajbista.weatherlearningmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_search.*
import np.com.nawarajbista.weatherlearningmvvm.R
import np.com.nawarajbista.weatherlearningmvvm.viewModel.SearchActivityViewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        viewModel = ViewModelProvider(this).get(SearchActivityViewModel::class.java)

        iv_search.setOnClickListener {
            viewModel.changeState()
        }



        viewModel.showProgress.observe(this, Observer {
            if(it)
                search_progress.visibility = VISIBLE
            else
                search_progress.visibility = GONE
        })
    }
}
