package com.relsellglobal.modelslib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.relsellglobal.modelslib.databinding.ActivityMainBinding


class DummyActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

    }
}