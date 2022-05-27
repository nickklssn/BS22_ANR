package io.moxd.myanr

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    private var on = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView.text = "[ placeholder for some random values ]"

        val on = true


        findViewById<Button>(R.id.run_button).setOnClickListener {
            run()

        }

        findViewById<Button>(R.id.stop_button).setOnClickListener {
            stop()
        }

    }


    // Erwartung: Der Run-Button liefert durchgehend randomisierte Werte über die TextView
    // Realität: Ein Klick auf den Run-Button lässt die App nicht mehr reagieren, keine Werte werden angezeigt und die App stürzt ab


    // Alte Run-Methode
/*    private fun run() {

        while (true) {
            textView.text = Random.nextInt().toString()

        }
    }*/


     private fun run() {

         on = true

        // Erstellung eines Handlers (sendet und verarbeitet Nachrichten) auf dem MainLooper
        val mainHandler = Handler(Looper.getMainLooper())

        //Hiermit wird eine Operation auf dem UI-Thread ausgeführt
         // Ein Runnable Object ist ein Objekt, das in eine Message Queue gesendet werden kann, um dort ausgeführt zu werden
         // Der Handler sendet das Objekt dorthin
        mainHandler.post(object : Runnable {
            //
            override fun run() {

                if (on) {
                    // Das Runnable wird in die Message Queue gelegt und nach 1500ms ausgeführt
                    mainHandler.postDelayed(this, 1500)
                    textView.text = Random.nextInt().toString()
                }
            }
        })
    }


     private fun stop() {

         on = false
         textView.text = "Thread has been stopped"

    }




        // Der Android-Profiler ist ein Echtzeit-Tool, das die benötigten Ressourcen CPU, Speicher, Netzwerk und Akku eigener Apps anzeigt
        // Je nachdem, welche Aktion durchgeführt wird, werden unterschiedliche Ressourcen verwendet
        // Beim einfachen Tippen auf das Display wird die CPU in einem sehr geringen Ausmaß genutzt (Speicher wird nicht gebraucht)
        // Beim Tippen auf den Start-Button hingegen werden alle Ressourcen verwendet (CPU, Speicher und Akku werden belastet)

        //Erklärung: Es werden scheinbar viele randomisierte Zahlen ausgegeben (hohe CPU-Auslastung + Memory-Nutzung) -> es kommt zum Stack-Overflow -> App stürzt ab
        // Hohe Energienutzung durch erhöhte CPU-Auslastung und Memory-Nutzung

    }
