package com.example.chatapp

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import com.example.chatapp.databinding.ActivityMainBinding
import com.example.chatapp.ui.globalsettings.KEY_THEME
import com.example.chatapp.ui.globalsettings.PREFS_NAME
import com.example.chatapp.utils.ConnectionLiveData

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!
    private val sharedPreferences by lazy {
        getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        changeTheme()
        initNavigation()
        checkInternet()

        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun checkInternet() {
        val connectivityManager =
            application.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val connectionLiveData =
            ConnectionLiveData(connectivityManager)
        connectionLiveData.observe(this) { isNetworkAvailable ->
            isNetworkAvailable?.let {
                updateUI(it)
            }
        }
    }

    private fun updateUI(isConnection: Boolean) {
        binding.noInternet.isVisible = !isConnection
    }

    private fun changeTheme() {
        if (sharedPreferences.getInt(KEY_THEME, -1) == R.style.Theme_ChatAppNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        setTheme(sharedPreferences.getInt(KEY_THEME, -1))
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navHostFragment.navController
    }

    fun recreateActivity() {
        ActivityCompat.recreate(this@MainActivity)
    }

}