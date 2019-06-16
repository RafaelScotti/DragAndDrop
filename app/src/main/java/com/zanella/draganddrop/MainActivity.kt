package com.zanella.draganddrop

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.zanella.draganddrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var text = "Write here"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding =  DataBindingUtil
            .setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.main = MainActivity()
    }
}
