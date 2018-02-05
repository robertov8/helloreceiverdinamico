package br.com.livroandroid.helloreceiverdinamico

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val helloReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("livroandroid", "HelloReceiver Dinamico!!!")
            tvTitulo.text = getString(R.string.mensagem_recebida)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Enviar broadcast
        btEnviar.setOnClickListener {
            sendBroadcast(Intent("BINGO"))
            Toast.makeText(this, "Intent enviada!", Toast.LENGTH_LONG).show()
        }
        // Registra o receiver
        registerReceiver(helloReceiver, IntentFilter("BINGO"))
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancela o receiver
        unregisterReceiver(helloReceiver)
    }
}
