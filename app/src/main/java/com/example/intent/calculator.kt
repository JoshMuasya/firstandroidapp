package com.example.intent

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class calculator : AppCompatActivity() {

    lateinit var add:Button
    lateinit  var minus:Button
    lateinit  var mult:Button
    lateinit  var divide:Button
    lateinit  var firstnumber:EditText
    lateinit var secondnumber:EditText
    lateinit var answer:TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        add = findViewById(R.id.Btn_Add)
        minus = findViewById(R.id.Btn_Sub)
        mult = findViewById(R.id.Btn_Multiply)
        divide = findViewById(R.id.Btn_Division)
        firstnumber = findViewById(R.id.Edt_Fnum)
        secondnumber = findViewById(R.id.Edt_Snum)
        answer = findViewById(R.id.Txt_Answer)

        add.setOnClickListener {
            val firstnum = firstnumber.text.toString()
            val secondnum = secondnumber.text.toString()

            if (firstnum.isEmpty() && secondnum.isEmpty()) {
                answer.text = "Please fill in all inputs"
            } else {
                val result = firstnum.toDouble() + secondnum.toDouble()
                answer.text=result.toString()
            }
        }

        minus.setOnClickListener {
            val firstnum = firstnumber.toString()
            val secondnum = secondnumber.toString()

            if (firstnum.isEmpty() && secondnum.isEmpty()) {
                answer.text = "Please fill in all inputs"
            } else {
                val result = firstnum.toDouble() - secondnum.toDouble()
                answer.text=result.toString()
            }
        }

        mult.setOnClickListener {
            val firstnum = firstnumber.toString()
            val secondnum = secondnumber.toString()

            if (firstnum.isEmpty() && secondnum.isEmpty()) {
                answer.text = "Please fill in all inputs"
            } else {
                val result = firstnum.toDouble() * secondnum.toDouble()
                answer.text=result.toString()
            }
        }

        divide.setOnClickListener {
            val firstnum = firstnumber.toString()
            val secondnum = secondnumber.toString()

            if (firstnum.isEmpty() && secondnum.isEmpty()) {
                answer.text = "Please fill in all inputs"
            } else {
                val result = firstnum.toDouble() / secondnum.toDouble()
                answer.text=result.toString()
            }
        }
    }
}