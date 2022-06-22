package com.relsellglobal.uiphonemod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.relsellglobal.progressbarlib.ChildDepedency
import javax.inject.Inject
import android.util.Log
import com.relsellglobal.progressbarlib.ChildFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector

class UiPhoneActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var childFragment: ChildFragment

//    @Inject
//    lateinit var childDepedency : ChildDepedency
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as UiApplicationClass).applicationComponent.inject(this)


        setContentView(R.layout.activity_ui_phone)
        //childDepedency.printMe()
//        startActivity(Intent(this@UiPhoneActivity,com.relsellglobal.progressbarlib.MainActivity::class.java))
        supportFragmentManager.beginTransaction().replace(R.id.rtlLayout,ChildFragment()).commit()

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}