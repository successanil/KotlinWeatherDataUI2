package com.relsellglobal.uiphonemod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UiPhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_phone)
        startActivity(Intent(this@UiPhoneActivity,com.relsellglobal.progressbarlib.MainActivity::class.java))

    }
}