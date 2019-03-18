package com.example.hm_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import java.util.concurrent.TimeUnit

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    val secondActivity = object : CountDownTimer(TimeUnit.SECONDS.toMillis(10), TimeUnit.SECONDS.toMillis(1)) {
        override fun onFinish() {
            val intent = Intent(this@Main2Activity, MainActivity::class.java)
            startActivity(intent)

        }

        override fun onTick(value: Long) {

        }
    }.start()

}
