package com.example.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview.*


class PreviewActivity : AppCompatActivity() {

    private var message: Message? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        message = intent.getSerializableExtra("Mes") as Message?

        text_view_preview_message.text = message.toString()

        button_send_message.setOnClickListener {
            sendData()
        }
    }

    private fun sendData() {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, message.toString())
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Please select app"))
    }
}
