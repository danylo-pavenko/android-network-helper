package com.dansdev.network_helper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.dansdev.android_network_helper_lib.isHasConnection
import com.dansdev.android_network_helper_lib.isInternetAvailable
import com.dansdev.android_network_helper_lib.isWifiConnection
import com.dansdev.network_helper.databinding.ActivityMainBinding
import java.util.concurrent.Executors
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)

        val executor = Executors.newSingleThreadExecutor()

        executor.submit {
            while (!isDestroyed) {
                val isHasConnection = isHasConnection()
                val isInternetAvailable = isInternetAvailable()
                val isWifi = isWifiConnection()
                Thread.sleep(500L)
                binding.root.post {
                    binding.viewPing.isVisible = !binding.viewPing.isVisible
                    binding.tvStatus.text = "Has connection: ${if (isHasConnection) "ON" else "OFF"} ${if (isWifi) " (WiFi)" else ""}"
                    binding.tvInternet.text = "Has Internet: ${if (isInternetAvailable) "ON" else "OFF"}"
                }
            }
        }
    }
}
