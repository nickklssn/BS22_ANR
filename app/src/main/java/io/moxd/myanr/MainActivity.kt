package io.moxd.myanr

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

    // Erwartung: Der Run-Button liefert durchgehend randomisierte Werte über die TextView
    // Realität: Ein Klick auf den Run-Button lässt die App nicht mehr reagieren, keine Werte werden angezeigt und die App stürzt ab

    private fun run() {

        while (true) {
            textView.text = Random.nextInt().toString()
        }
    }

    private fun stop() {

        textView.text = "[ placeholder for some random values ]"
    }

    // Der Android-Profiler ist ein Echtzeit-Tool, das die benötigten Ressourcen CPU, Speicher, Netzwerk und Akku eigener Apps anzeigt
    // Je nachdem, welche Aktion durchgeführt wird, werden unterschiedliche Ressourcen verwendet
    // Beim einfachen Tippen auf das Display wird die CPU in einem sehr geringen Ausmaß genutzt (Speicher wird nicht gebraucht)
    // Beim Tippen auf den Start-Button hingegen werden alle Ressourcen verwendet (CPU, Speicher und Akku werden belastet)

    //Erklärung: Es werden scheinbar viele randomisierte Zahlen ausgegeben (hohe CPU-Auslastung + Memory-Nutzung) -> es kommt zum Stack-Overflow -> App stürzt ab
    // Hohe Energienutzung durch erhöhte CPU-Auslastung und Memory-Nutzung

}