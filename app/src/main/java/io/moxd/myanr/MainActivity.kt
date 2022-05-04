package io.moxd.myanr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView.text = "[ placeholder for some random values ]"


        findViewById<Button>(R.id.run_button).setOnClickListener {
            run()
        }

        findViewById<Button>(R.id.stop_button).setOnClickListener {
            stop()
        }
    }

    private fun run() {

            textView.text = Random.nextInt().toString()
    }

    private fun stop() {
            textView.text = "[ placeholder for some random values ]"
    }

}