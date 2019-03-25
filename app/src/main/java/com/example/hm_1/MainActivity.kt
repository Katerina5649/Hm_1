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
import kotlin.math.pow
import android.content.Intent




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //vat т.к i изменяемое
    var i :Int = 0
    val timer = object : CountDownTimer(TimeUnit.SECONDS.toMillis(10), TimeUnit.SECONDS.toMillis(1)) {
        override fun onFinish() {
            start()
        }

        override fun onTick(value: Long) {
            i++
            if (i >= 1000){
                startbutton.callOnClick()
                text.text = "ноль"
            }
            else
                text.text = convertIntToWord(i)
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
            i = 0
            text.setText("Ноль")
            startbutton.setText("Старт")
        }


    }

    fun convertIntToWord(digit : Int) :String {
        var stringDigit : String
        val length: Int = digit.toString().length
         stringDigit  = when(digit) {
             1 -> "один"
             2 -> "два"
             3 -> "три"
             4 -> "четыре"
             5 -> "пять"
             6 -> "шесть"
             7 -> "семь"
             8 -> "восемь"
             9 -> "девять"
             10 -> "десять"
             11 -> "одиннадцать"
             12 -> "двенадцать"
             13 -> "тринадцать"
             14 -> "четырнадцать"
             15 -> "пятнадцать"
             16 -> "шестнадцать"
             17 -> "семнадцать"
             18 -> "восемнадцат"
             19 -> "девятнадцать"
             20 -> "двадцать"
             30 -> "тридцать"
             40 -> "сорок"
             50 -> "пятдесят"
             60 -> "шестдесят"
             70 -> "семдесят"
             80 -> "восемдесят"
             90 -> "девяносто"
             100 -> "сто"
             200 -> "двести"
             300-> "триста"
             400 -> "четыреста"
             500 -> "пятьсот"
             600 -> "шестьсот"
             700 -> "семьсот"
             800 -> "восемьсот"
             900 -> "девятьсот"
             else -> convertIntToWord((digit / 10.toDouble().pow(length-1).toInt())*10.toDouble().pow(length-1).toInt())+" "+ convertIntToWord(digit % 10.toDouble().pow(length-1).toInt())
         }



        return stringDigit
    }




}








