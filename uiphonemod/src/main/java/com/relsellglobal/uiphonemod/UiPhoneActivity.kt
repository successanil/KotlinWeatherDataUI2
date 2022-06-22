package com.relsellglobal.uiphonemod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.relsellglobal.progressbarlib.ChildDepedency
import javax.inject.Inject
import android.util.Log
import dagger.android.AndroidInjection

class UiPhoneActivity : AppCompatActivity() {
    @Inject
    lateinit var childDepedency : ChildDepedency
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as UiApplicationClass).applicationComponent.inject(this)


        setContentView(R.layout.activity_ui_phone)
        childDepedency.printMe()
        startActivity(Intent(this@UiPhoneActivity,com.relsellglobal.progressbarlib.MainActivity::class.java))

    }
}