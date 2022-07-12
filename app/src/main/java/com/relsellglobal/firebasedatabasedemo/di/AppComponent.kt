package com.relsellglobal.firebasedatabasedemo.di


import com.relsellglobal.firebasedatabasedemo.MyApplication
import com.relsellglobal.localdblib.di.LocalDBMod
import com.relsellglobal.networklib.di.NetworkModule
import com.relsellglobal.repositorymodule.di.RepositoryMod
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules=[
    AndroidInjectionModule::class,
    ActivitiesContributerModule::class,
    NetworkModule::class,
    LocalDBMod::class,
    RepositoryMod::class,
    FragmentContributerModule::class])
interface AppComponent {
    fun inject(app: MyApplication)
}