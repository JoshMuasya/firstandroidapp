package com.example.intent

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val buttonSms: Button = findViewById(R.id.Btn_Sms)
        val buttonDial: Button=findViewById(R.id.Btn_Dial)
        val buttonEmail: Button =findViewById(R.id.Btn_Email)
        val buttonStk: Button=findViewById(R.id.Btn_Stk)
        val buttonCall: Button=findViewById(R.id.Btn_Call)
        val buttonShare: Button =findViewById(R.id.Btn_Share)
        val buttonCamera: Button=findViewById(R.id.Btn_Camera)

        buttonSms.setOnClickListener {
            val uri = Uri.parse("smsto:0798040353")

            val intent = Intent(Intent.ACTION_SENDTO, uri)

            intent.putExtra("Hello", "Hows the weather today?")

            startActivity(intent)
        }

        buttonDial.setOnClickListener {
            val phone = "+254175321548623"

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))

            startActivity(intent)
        }

        buttonEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "johndoe@gmail.com", null))

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send Email..."))
        }

        buttonStk.setOnClickListener {
            val simToolKitIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitIntent?.let { startActivity(it) }
        }

        buttonCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+25472125458623"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }

        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)
        }

        buttonCamera.setOnClickListener {
            val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            startActivityForResult(pictureIntent, 1)
        }
    }
}