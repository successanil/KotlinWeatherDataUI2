package com.relsellglobal.firebasedatabasedemo

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.firebasedatabasedemo.databinding.ActivityMainWithNavBarBinding
import com.relsellglobal.modelslib.drawer.DrawerItem

class MainActivityWithNavBar : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainWithNavBarBinding

    private var drawerRV: RecyclerView? = null
    var drawerItemList: List<DrawerItem?> = ArrayList()
    var mDrawerToggle: ActionBarDrawerToggle? = null
    var drawer: DrawerLayout ?= null
    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainWithNavBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.appBarMainActivityWithNavBar.toolbar

        setSupportActionBar(toolbar)

        //binding.appBarMainActivityWithNavBar.

//        binding.appBarMainActivityWithNavBar.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        drawer = binding.drawerLayout

        mDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
            }
        }

        drawerRV = binding.drawerRV
//        val navView: NavigationView = binding.navView
//        val navController = findNavController(R.id.nav_host_fragment_content_main_activity_with_nav_bar)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
//            ), drawer
//        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
        mDrawerToggle?.syncState()
    }



}