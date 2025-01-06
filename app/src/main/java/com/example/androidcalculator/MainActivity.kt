package com.example.androidcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var hourFirstOperandET: EditText
    private lateinit var minuteFirstOperandET: EditText
    private lateinit var secondFirstOperandET: EditText

    private lateinit var hourSecondOperandET: EditText
    private lateinit var minuteSecondOperandET: EditText
    private lateinit var secondSecondOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var buttonResetBTN: Button
    private lateinit var buttonExitBTN: Button


    private lateinit var resultTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        hourFirstOperandET = findViewById(R.id.hourFirstOperandET)
        minuteFirstOperandET = findViewById(R.id.minuteFirstOperandET)
        secondFirstOperandET = findViewById(R.id.secondFirstOperandET)
        hourSecondOperandET = findViewById(R.id.hourSecondOperandET)
        minuteSecondOperandET = findViewById(R.id.minuteSecondOperandET)
        secondSecondOperandET = findViewById(R.id.secondSecondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExitBTN = findViewById(R.id.buttonExitBTN)

        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
        buttonResetBTN.setOnClickListener(this)
        buttonExitBTN.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var check = true

        if (hourFirstOperandET.text.isEmpty()
            || minuteFirstOperandET.text.isEmpty()
            || secondFirstOperandET.text.isEmpty()
            || hourSecondOperandET.text.isEmpty()
            || minuteSecondOperandET.text.isEmpty()
            || secondSecondOperandET.text.isEmpty()
        ) {
            return
        }

        var hourFirst = hourFirstOperandET.text.toString().toInt()
        var minuteFirst = minuteFirstOperandET.text.toString().toInt()
        var secondFirst = secondFirstOperandET.text.toString().toInt()
        var hourSecond = hourSecondOperandET.text.toString().toInt()
        var minuteSecond = minuteSecondOperandET.text.toString().toInt()
        var secondSecond = secondSecondOperandET.text.toString().toInt()



        var result = when (v?.id) {
            R.id.buttonDifBTN -> TimeOperation(hourFirst, minuteFirst, secondFirst,
                hourSecond,minuteSecond, secondSecond).dif()
            R.id.buttonSumBTN -> TimeOperation(hourFirst, minuteFirst, secondFirst,
                hourSecond,minuteSecond, secondSecond).sum()
            R.id.buttonResetBTN -> {
                hourFirstOperandET.text.clear()
                minuteFirstOperandET.text.clear()
                secondFirstOperandET.text.clear()
                hourSecondOperandET.text.clear()
                minuteSecondOperandET.text.clear()
                secondSecondOperandET.text.clear()
                check = false
            }
                R.id.buttonExitBTN -> finish()
                else -> 0
        }
        if (!check) resultTV.text = "Результат" else resultTV.text = result.toString()
    }
}