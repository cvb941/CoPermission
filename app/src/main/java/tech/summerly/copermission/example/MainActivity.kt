package tech.summerly.copermission.example

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import tech.summerly.copermission.requestPermission

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun requestReadPhoneState(view: View) {
        lifecycleScope.launch {
            val isGranted = requestPermission(Manifest.permission.READ_PHONE_STATE)
            toast("isGranted ? : $isGranted")
        }
    }

    fun request2(view: View) {
        lifecycleScope.launch {
            val isGranted = requestPermission(Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION)
            toast("isGranted ? : ${isGranted.joinToString()}")
        }
    }

    private fun toast(string: String) = lifecycleScope.launch {
        Toast.makeText(this@MainActivity, string, Toast.LENGTH_SHORT).show()
    }
}
