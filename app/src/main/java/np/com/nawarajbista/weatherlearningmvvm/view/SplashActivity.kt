package np.com.nawarajbista.weatherlearningmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import np.com.nawarajbista.weatherlearningmvvm.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed( {
            val intent = Intent(this,SearchActivity::class.java)
            startActivity(intent)
        }, 2000)
    }

}
