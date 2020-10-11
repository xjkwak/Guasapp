package com.xjkwak.guasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_message.*

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        if (intent.hasExtra(EXTRA_MESSAGE)) {
            handleSendText(intent) // Handle text being sent
        }
    }

    private fun handleSendText(intent: Intent) {
//        intent.getStringExtra(EXTRA_MESSAGE)?.let {
//            completeMessage.text = it
//        }
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        completeMessage.text = message
    }
}