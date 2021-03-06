package com.sadewawicak.livedataapps

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver: Observer<Long?> = Observer { t ->
            val newText = "${resources?.getString(R.string.seconds)} : $t"
            timer_textview.text = newText
        }
        viewModel.getElapsedTime()?.observe(this, elapsedTimeObserver)
    }

    private fun doAction() {
        Log.i("i", "")
    }

}
