package loginapp.example.fzlbpms.com.br.exampleloginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.toast


class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btLogin : Button = findViewById<Button>(R.id.btLogin)

        btLogin.setOnClickListener(View.OnClickListener {
            val textViewLogin: TextView = findViewById<TextView>(R.id.etUserName) as TextView
            toast(textViewLogin.text) })
    }


}
