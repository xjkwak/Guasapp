package com.xjkwak.guasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val EXTRA_MESSAGE = "com.xjkwak.guasapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preview.setOnClickListener{
            openDisplayMessageActivity()
        }

        send.setOnClickListener {
            openAnotherActivity()
        }
    }

    private fun openDisplayMessageActivity() {
        val sendIntent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, completeMessage.text.toString())
        }
        startActivity(sendIntent)
    }

    private fun openAnotherActivity() {
        // Create the text message with a string
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, completeMessage.text.toString())
            type = "text/plain"
        }

        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }
    }
}