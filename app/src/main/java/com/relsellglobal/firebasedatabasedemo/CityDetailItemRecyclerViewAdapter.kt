/*
 * Copyright (c) 2019. Relsell Global
 */

package com.relsellglobal.firebasedatabasedemo


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.firebasedatabasedemo.databinding.FragmentDetailRowItemBinding
import com.relsellglobal.modelslib.CityContent

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class CityDetailItemRecyclerViewAdapter(
    private val mValues: List<CityContent>,
    private val activity: FragmentActivity
    ) : RecyclerView.Adapter<CityDetailItemRecyclerViewAdapter.ViewHolder>() {

    private lateinit var binding : FragmentDetailRowItemBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.fragment_detail_row_item, parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.cityName.text = item.cityName


    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val cityName: TextView = mView.findViewById(R.id.cityName)
//
//        override fun toString(): String {
//            return super.toString() + " '" + mContentView.text + "'"
//        }
    }
}
