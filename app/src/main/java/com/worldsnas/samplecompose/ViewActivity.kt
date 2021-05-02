package com.worldsnas.samplecompose

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {

    var counterNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val counter = findViewById<TextView>(R.id.counterView)
        counter.text = getString(R.string.greetings) + " $counterNum"

        counter.setOnClickListener {

            counterNum++
            counter.text = getString(R.string.greetings) + " $counterNum"
        }
    }
}