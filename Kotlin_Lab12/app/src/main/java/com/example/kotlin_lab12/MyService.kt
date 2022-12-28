package com.example.kotlin_lab12
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        runBlocking{
            launch {
                try {
                    delay(5000L)
                    val intent = Intent(this@MyService, SecActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        return START_NOT_STICKY
    }
    override fun onBind(intent: Intent): IBinder? = null
}