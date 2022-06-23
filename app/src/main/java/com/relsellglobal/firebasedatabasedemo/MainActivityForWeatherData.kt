/*
 * Copyright (c) 2019. Relsell Global
 */


package com.relsellglobal.firebasedatabasedemo

import com.relsellglobal.firebasedatabasedemo.databinding.ActivityMainListviewRootBinding
import com.relsellglobal.firebasedatabasedemo.pojo.CityContent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.localdblib.entities.CityContentDB
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityForWeatherData : AppCompatActivity(),HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    lateinit var binding : ActivityMainListviewRootBinding

    @Inject
    lateinit var frontListFragment : FrontListFragment

    @Inject
    lateinit var database : CityDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_listview_root)

        triggerDBDemoCall()

        val fragmentManager = supportFragmentManager
        val fT = fragmentManager.beginTransaction()
        fT.replace(R.id.root,frontListFragment)
        fT.commit()




    }

    fun triggerDBDemoCall () {
        CoroutineScope(Dispatchers.IO).launch {
            database.cityContentDao().insertCityContent(CityContentDB(0,"delhi","{}"))
        }
    }

    fun launchDetailFragment(item: CityContent) {
        val fragmentManager = supportFragmentManager
        val fT = fragmentManager.beginTransaction()
        val detailFragment = DetailFragment()
        val b = Bundle()
        b.putParcelable("cityContent",item);
        detailFragment.arguments = b
        fT.replace(R.id.root,detailFragment)
        fT.addToBackStack(null)
        fT.commit()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector;
    }


}
