package com.relsellglobal.firebasedatabasedemo.ui.home

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.firebasedatabasedemo.MyApplication
import com.relsellglobal.firebasedatabasedemo.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HomeActivity : AppCompatActivity(),HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        (applicationContext as MyApplication).appComponent.inject(this)



        supportFragmentManager.beginTransaction().replace(R.id.rootL,homeFragment).commit()


//        // getting the recyclerview by its id
//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
//
//        // this creates a vertical layout Manager
//        recyclerview.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
//
//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsModel>()
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsModel(R.drawable.main_bg, "Item " + i))
//        }
//
//        // This will pass the ArrayList to our Adapter
//        val adapter = CustomAdapter(data)
//
//        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }
}
