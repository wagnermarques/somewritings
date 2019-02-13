package com.example.wagner.projsobreactivity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_main2.*
import android.util.Log;


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Main1Activity", ">>>On Create Rodou...")

        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
    override fun onResume() {
        super.onResume()
        Log.i("Main1Activity", ">>> On Resume Rodou...")
    }
    override fun onPause() {
        super.onPause()
        Log.i("Main1Activity", ">>> On Pause Rodou...")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("Main1Activity", ">>> On Restart Rodou...")
    }
    override fun onStart() {
        super.onStart()
        Log.i("Main1Activity", ">>> On Start Rodou...")
    }
    override fun onStop() {
        super.onStop()
        Log.i("Main1Activity", ">>> On Stop Rodou...")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main1Activity", ">>> On Destroy Rodou...")
    }
}
