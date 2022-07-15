package com.relsellglobal.firebasedatabasedemo.helpers

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentLaunchBackHelpers {

    companion object{
        fun launchFragmentCommon(layoutId:Int,supportFragmentManager: FragmentManager,fragment:Fragment,addToBackStack : Boolean =
            false,bundle : Bundle? = null) {
            val fT = supportFragmentManager.beginTransaction()
            fT.replace(layoutId,fragment)
            if(addToBackStack) {
                fT.addToBackStack(null)
            }
            if(bundle != null) {
                fragment.arguments = bundle
            }
            fT.commit()
        }

        fun comeBackFromFragmentCommon(layoutId:Int,supportFragmentManager:FragmentManager,targetFragmentToBeShown:Fragment,
                                       outgoingFragment : Fragment){
            supportFragmentManager.popBackStack()
        }



    }
}