/*
 * Copyright (c) 2019. Relsell Global
 */


package com.relsellglobal.firebasedatabasedemo

import com.relsellglobal.firebasedatabasedemo.databinding.ActivityMainListviewRootBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.relsellglobal.firebasedatabasedemo.helpers.FragmentLaunchBackHelpers
import com.relsellglobal.firebasedatabasedemo.ui.addcity.AddCityFragment
import com.relsellglobal.firebasedatabasedemo.utils.Utils
import com.relsellglobal.localdblib.database.CityDatabase
import com.relsellglobal.localdblib.entities.CityContentDB
import com.relsellglobal.modelslib.CityContent
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
    lateinit var addCityFragment : AddCityFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_listview_root)

        if(savedInstanceState == null) {
            launchFrontListFragment()
            //launchAddCityFragment()
        }

        // This only be called for new application when db is not there
        // add user prefs here
        //setupWorkerForDefaultCities()






    }

    private fun setupWorkerForDefaultCities() {
        Utils.setUpWorkerForDefaultCityFetch(MyApplication.getMyApplicationObj().applicationContext)
    }

    fun launchFrontListFragment() {
        val b = Bundle()
        FragmentLaunchBackHelpers.launchFragmentCommon(R.id.root,supportFragmentManager,frontListFragment,false,b)
    }

    fun launchAddCityFragment() {
        val b = Bundle()
        FragmentLaunchBackHelpers.launchFragmentCommon(R.id.root,supportFragmentManager,addCityFragment,true,b)
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
