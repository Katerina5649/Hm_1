package com.example.hm_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*
import android.os.CountDownTimer
import android.view.View
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    val i :Int = 0
    val timer = object : CountDownTimer(TimeUnit.SECONDS.toMillis(10), TimeUnit.SECONDS.toMillis(3)) {
        override fun onFinish() {
            start()
        }

        override fun onTick(value: Long) {
            //Пробовала i.rangeTo(i+1), i.plus(1)
            i.inc()
            //Пробовала text.setText(i), не сработало
            text.text = i.toString()
        }
    }


    var isPlaying = false
    fun Timer(v: View){
        if (!isPlaying) {
            isPlaying = true
            startbutton.setText("Стоп")
            timer.start()

        } else {
            timer.cancel()
            isPlaying = false
            i.rangeTo(0)
            text.setText("0")
            startbutton.setText("Старт")
        }


    }


}




