package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalc: Button = findViewById(R.id.Btn_Calc)
        val buttonIntent: Button = findViewById(R.id.Btn_Intent)
        val buttonWeb: Button = findViewById(R.id.Btn_Web)

        buttonCalc.setOnClickListener {
            val intent = Intent(this, calculator::class.java)
            startActivity(intent)
        }

        buttonIntent.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }

        buttonWeb.setOnClickListener {
            val intent = Intent(this, Web::class.java)
            startActivity(intent)
        }
    }
}