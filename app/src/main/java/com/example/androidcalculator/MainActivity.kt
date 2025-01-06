package com.example.androidcalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.*



class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbarMain: Toolbar

    private lateinit var hourFirstOperandET: EditText
    private lateinit var minuteFirstOperandET: EditText
    private lateinit var secondFirstOperandET: EditText

    private lateinit var hourSecondOperandET: EditText
    private lateinit var minuteSecondOperandET: EditText
    private lateinit var secondSecondOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button

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
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор времени"
        toolbarMain.subtitle = "Версия 2"
        toolbarMain.setLogo(R.drawable.ic_calculate)



        hourFirstOperandET = findViewById(R.id.hourFirstOperandET)
        minuteFirstOperandET = findViewById(R.id.minuteFirstOperandET)
        secondFirstOperandET = findViewById(R.id.secondFirstOperandET)
        hourSecondOperandET = findViewById(R.id.hourSecondOperandET)
        minuteSecondOperandET = findViewById(R.id.minuteSecondOperandET)
        secondSecondOperandET = findViewById(R.id.secondSecondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)

        resultTV = findViewById(R.id.resultTV)

        buttonSumBTN.setOnClickListener(this)
        buttonDifBTN.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.resetManuMain -> {
                hourFirstOperandET.text.clear()
                minuteFirstOperandET.text.clear()
                secondFirstOperandET.text.clear()
                hourSecondOperandET.text.clear()
                minuteSecondOperandET.text.clear()
                secondSecondOperandET.text.clear()
                resultTV.text = "Результат"
                Toast.makeText(
                    applicationContext,
                    "Данные очищены",
                    Toast.LENGTH_LONG
                ).show()
                resultTV.setTextColor(resources.getColor(R.color.black))
            }
            R.id.exitManuMain -> {
                Toast.makeText(
                    applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
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


        resultTV.text = when (v?.id) {

            R.id.buttonDifBTN -> TimeOperation(
                hourFirst, minuteFirst, secondFirst,
                hourSecond, minuteSecond, secondSecond
            ).dif()

            R.id.buttonSumBTN -> TimeOperation(
                hourFirst, minuteFirst, secondFirst,
                hourSecond, minuteSecond, secondSecond
            ).sum()



            else -> 0.toString()

        }

        if (resultTV.text != "Ошибка вычисления") {
            resultTV.setTextColor(resources.getColor(R.color.redOne))
        }
        Toast.makeText(
            applicationContext,
            resultTV.text.toString(),
            Toast.LENGTH_LONG
        ).show()
    }
}